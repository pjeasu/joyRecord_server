package com.joy.record.service;


import com.joy.record.model.AttachFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface FileService {
    public AttachFile uploadFiles(MultipartFile files, HashMap<String, Object> param);

    public AttachFile getFile(int fileId);

    public boolean isImageFile(String contentType);
}
