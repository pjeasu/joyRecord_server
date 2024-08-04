package com.joy.record.controller;

import com.joy.record.model.AttachFile;
import com.joy.record.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.IOUtils;


@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    private static final String UPLOAD_FOLDER = "/mnt/newvolume/uploads"; // 실제 업로드 폴더 경로


    /**
     * 파일 여러개 업로드
     * @param files array of files to be uploaded
     * @return list of uploaded file metadata
     */
    @PostMapping("/upload")
    public ResponseEntity<List<AttachFile>> uploadFiles(@RequestParam("files") MultipartFile[] files,  @RequestParam("param") String param) {
        List<AttachFile> uploadedFiles = fileService.uploadFiles(files, param);
        return ResponseEntity.ok(uploadedFiles);
    }

    /**
     * 파일 ID로 파일을 다운로드
     *
     * @param fileId the ID of the file to be downloaded
     * @return the file as a resource
     */
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int fileId) {
        AttachFile attachFile = fileService.getFile(fileId);
        // 파일 경로를 생성하고 리소스 생성
        Path path = Paths.get(attachFile.getFile_path());
        Resource resource;
        try {
            resource = new UrlResource(path.toUri());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        // 파일을 다운로드 가능한 리소스로 반환
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachFile.getFile_name() + "\"")
                .body(resource);
    }

    /** 이미지 화면에 출력 */
    @GetMapping(value = "/image/{imageName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getImageAsBase64(@PathVariable String imageName) throws IOException {
        Path imagePath = Paths.get(UPLOAD_FOLDER, imageName);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            return "{\"image\": \"" + base64Image + "\"}";
        } else {
            return "{\"error\": \"Image not found\"}";
        }
    }

}