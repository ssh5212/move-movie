package com.ssafy.mm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mm.model.my_bucket_list_DTO;
import com.ssafy.mm.model.service.MyBucketListService;

@RestController
@RequestMapping("/mybucket")
public class MybucketController {
	public static final Logger logger = LoggerFactory.getLogger(MybucketController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private MyBucketListService myBucketListService;
	
	
	@PostMapping("/checkedupdate")
	public ResponseEntity<Map<String, Object>> checkedupdate(@RequestBody my_bucket_list_DTO dto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		logger.info(dto.toString());
		
		try {
//			myBucketListService.updateChecked(dto.getUser_pk(), dto.getSpot_pk(), dto.getChecked());
			myBucketListService.updateChecked(dto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/selectCheck")
	public ResponseEntity<Map<String, Object>> selectCheck(@RequestBody my_bucket_list_DTO dto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		System.out.println(dto);
		
		try {
			List<my_bucket_list_DTO> res = myBucketListService.selectcheck(dto);			
			resultMap.put("spotCheck", res);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
//	selectUserBucket
	@PostMapping("/selectUserBucket")
	public ResponseEntity<Map<String, Object>> selectUserBucket(@RequestBody my_bucket_list_DTO dto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		logger.info(dto.toString());
		List<my_bucket_list_DTO> list;
		try {
			list = myBucketListService.selectUserBucket(dto);
			resultMap.put("MyBucket", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}
