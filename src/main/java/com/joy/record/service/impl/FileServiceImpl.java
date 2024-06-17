package com.joy.record.service.impl;

import com.joy.record.mapper.AttachFileMapper;
import com.joy.record.model.AttachFile;
import com.joy.record.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private final String uploadDir = "uploads/";

    @Autowired
    private AttachFileMapper attachFileMapper;

    /**
     * 여러 파일을 업로드하고 메타데이터를 데이터베이스에 저장
     *
     * @param files array of files to be uploaded
     * @return list of uploaded file metadata
     */
    public List<AttachFile> uploadFiles(MultipartFile[] files) {
        List<AttachFile> uploadedFiles = new ArrayList<>();

        try {
            for (MultipartFile file : files) {
                // 파일의 MIME 타입 검사
                String contentType = file.getContentType();
                if (!isImageFile(contentType)) {
                    throw new IllegalArgumentException("이미지 파일만 업로드할 수 있습니다.");
                }


                AttachFile attachFile = new AttachFile();
                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(uploadDir, fileName);

                // 디렉토리가 존재하는지 확인하고 없으면 생성
                Files.createDirectories(filePath.getParent());
                // 파일을 대상 위치에 복사
                Files.copy(file.getInputStream(), filePath);

                // 파일 메타데이터를 설정합니다.
                attachFile.setFile_name(fileName);
                attachFile.setFile_type(file.getContentType());
                attachFile.setFile_path(filePath.toString());

                // 파일 메타데이터를 데이터베이스에 삽입
                attachFileMapper.insertAttachFile(attachFile);

                // 결과 리스트에 파일 메타데이터를 추가
                uploadedFiles.add(attachFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return uploadedFiles;
    }

    /**
     * 파일 ID로 파일 메타데이터를 조회
     *
     * @param fileId the ID of the file to be retrieved
     * @return the file metadata
     */
    public AttachFile getFile(int fileId) {
        return attachFileMapper.selectAttachFileById(fileId);
    }


    /**
     * 주어진 MIME 타입이 이미지 파일인지 확인합니다.
     *
     * @param contentType MIME 타입
     * @return 이미지 파일이면 true, 아니면 false
     */
    public boolean isImageFile(String contentType) {
        return contentType != null && (
                contentType.equals("image/jpeg") ||
                        contentType.equals("image/png") ||
                        contentType.equals("image/gif")
        );
    }
}