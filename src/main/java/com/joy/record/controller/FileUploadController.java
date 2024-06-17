package com.joy.record.controller;

import com.joy.record.model.AttachFile;
import com.joy.record.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    /**
     * 파일 여러개 업로드
     * @param files array of files to be uploaded
     * @return list of uploaded file metadata
     */
    @PostMapping("/upload")
    public ResponseEntity<List<AttachFile>> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        List<AttachFile> uploadedFiles = fileService.uploadFiles(files);
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
}