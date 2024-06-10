package com.joy.record;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;


@SpringBootApplication
public class RecordApplication {


//	@Value("${upload.directory}")
//	private String uploadDirectory;

	public static void main(String[] args) {
		SpringApplication.run(RecordApplication.class, args);
	}


	/**
	 * 업로드한 파일을 서버 내부 스토리지에 저장하기 위해 실행시 디렉터리 생성
	 * */
//	@PostConstruct
//	public void init() {
//		File directory = new File(uploadDirectory);
//		if (!directory.exists()) {
//			directory.mkdirs(); // 디렉터리 생성
//		}
//	}



}
