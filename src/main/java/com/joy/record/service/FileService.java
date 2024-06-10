package com.joy.record.service;


import com.joy.record.model.AttachFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    public List<AttachFile> uploadFiles(MultipartFile[] files);

    public AttachFile getFile(int fileId);

    public boolean isImageFile(String contentType);
}
