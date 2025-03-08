package com.joy.record.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.joy.record.service.FileService;
import com.joy.record.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public HashMap<String, Object> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("param") String param) {
        HashMap<String, Object> response = new HashMap<>();

        // 파일 업로드 서비스 호출
        try {
            String fileUrl = fileUploadService.uploadFileToS3(file);
            response.put("message", "File uploaded successfully!");
            response.put("fileUrl", fileUrl);
            response.put("new_board_id", param);
            fileService.uploadFiles(file, response);

        } catch (IOException e) {
            response.put("message", "File upload failed!");
        }

        return response;
    }

}
