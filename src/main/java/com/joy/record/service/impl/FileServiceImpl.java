package com.joy.record.service.impl;

import com.joy.record.mapper.AttachFileMapper;
import com.joy.record.mapper.BoardFileRMapper;
import com.joy.record.model.AttachFile;
import com.joy.record.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;


@Service
public class FileServiceImpl implements FileService {


    @Autowired
    private AttachFileMapper attachFileMapper;

    @Autowired
    private BoardFileRMapper boardFileRMapper;

    /**
     * 파일을 업로드하고 메타데이터를 데이터베이스에 저장
     *
     * @param file to be uploaded
     * @return list of uploaded file metadata
     */
    public AttachFile uploadFiles(MultipartFile file, HashMap<String, Object> param) {

        AttachFile attachFile = new AttachFile();
        try {
            // 파일의 MIME 타입 검사
            String contentType = file.getContentType();
            if (!isImageFile(contentType)) {
                throw new IllegalArgumentException("이미지 파일만 업로드할 수 있습니다.");
            }
            String originalFileName = file.getOriginalFilename();

            // 업로드된 파일의 URL
            String fileUrl = param.get("fileUrl").toString();
            String new_board_id = param.get("new_board_id").toString();

            // 파일 메타데이터 설정
            attachFile.setFile_name(originalFileName);
            attachFile.setFile_type(contentType);
            attachFile.setFile_path(fileUrl);  // S3 URL 저장

            // 파일 메타데이터를 DB에 저장
            attachFileMapper.insertAttachFile(attachFile);

            // 게시글과 파일을 연결하는 테이블에 데이터 추가
            HashMap<String, Object> relParam = new HashMap<>();
            relParam.put("board_id", new_board_id);
            relParam.put("file_id", attachFile.getFile_id());
            boardFileRMapper.insertBoardFileR(relParam);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return attachFile;
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

    /**  파일 확장자 추출 */
    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        return (lastIndex == -1) ? "" : fileName.substring(lastIndex);
    }
}