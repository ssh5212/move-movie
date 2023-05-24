package com.ssafy.mm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mm.model.SpotInstanceDto;
import com.ssafy.mm.model.UserDto;
import com.ssafy.mm.model.service.SpotInstanceService;

@RestController
@RequestMapping("/SpotInst")
public class SpotInstanceController {
	public static final Logger logger = LoggerFactory.getLogger(SpotInstanceController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private SpotInstanceService spotInstanceService;
	
	@Value("${file.Path.spotinst}")
    private String uploadPath;
    
    @Value("${request.Path.spotinst.db}")
	private String profilerequest;
    
    // insert
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> register(@RequestPart(name="spotInstance") SpotInstanceDto spotInstanceDto,  @RequestPart(name = "file" , required = false) MultipartFile file){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String filePath = "";
		String filename = "";
		System.out.println(spotInstanceDto);
		//이미지 파일 local에 저장하기
        try {
        	filename = spotInstanceDto.getSpot_pk()+ "_"+spotInstanceDto.getUser_pk() +file.getOriginalFilename();
        	filePath = uploadPath + File.separator + filename;
        	File dest = new File(filePath);
			file.transferTo(dest);
			System.out.println(filePath);
			logger.debug("File uploaded successfully: {}", file.getOriginalFilename());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
        String fileRequestPath = profilerequest + filename;
        
		spotInstanceDto.setSpot_instance_img_src(fileRequestPath);
		try {
			spotInstanceService.insert(spotInstanceDto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("회원가입 실패 : ", e);
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	//select
}
