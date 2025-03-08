package com.joy.record.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    private final AmazonS3 amazonS3;

    public FileUploadService(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public String uploadFileToS3(MultipartFile file) throws IOException {
        // 로컬 파일 시스템에 임시 파일 저장
        Path tempFile = Files.createTempFile("upload-", file.getOriginalFilename());
        Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

        // S3에 업로드
        File fileToUpload = tempFile.toFile();
        amazonS3.putObject(new PutObjectRequest(bucketName, file.getOriginalFilename(), fileToUpload));

        // 임시 파일 삭제
        Files.delete(tempFile);

        // 업로드된 파일의 URL 반환
        return amazonS3.getUrl(bucketName, file.getOriginalFilename()).toString();
    }
}
