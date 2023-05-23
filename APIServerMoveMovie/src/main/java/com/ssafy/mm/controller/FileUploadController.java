package com.ssafy.mm.controller;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {
//	@Value("${file.path}")
//	private String uploadPath;

	@Autowired
	ServletContext servletContext;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		String uploadPath = servletContext.getRealPath("/upload");
		System.out.println(uploadPath);
		if (file.isEmpty()) {
			return new ResponseEntity<>("No file uploaded", HttpStatus.BAD_REQUEST);
		}

		try {
			// 업로드할 파일의 저장 경로
			String filePath = uploadPath + File.separator + file.getOriginalFilename();
			File dest = new File(filePath);
			file.transferTo(dest);
			System.out.println("======================");
			System.out.println(uploadPath);
			System.out.println(filePath);

//            logger.debug("File uploaded successfully: {}", file.getOriginalFilename());

			return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to upload file", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
