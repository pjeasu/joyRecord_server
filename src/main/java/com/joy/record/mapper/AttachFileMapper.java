package com.joy.record.mapper;

import com.joy.record.model.AttachFile;
import com.joy.record.model.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AttachFileMapper {

    void insertAttachFile(AttachFile attachFile);

    AttachFile selectAttachFileById(@Param("file_id") int fileId);
}


