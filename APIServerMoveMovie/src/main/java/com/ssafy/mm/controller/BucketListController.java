package com.ssafy.mm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mm.model.Bucket_detail_List_DTO;
import com.ssafy.mm.model.service.BucketDetailListService;

@RestController
@RequestMapping("/bucketList")
public class BucketListController {

	public static final Logger logger = LoggerFactory.getLogger(BucketListController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BucketDetailListService bucketDetailListService;

	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> selectDetails() {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		List<Bucket_detail_List_DTO> list;

		try {
			list = bucketDetailListService.selectDetails();
			resultMap.put("BucketDetailList", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@GetMapping("/{bucket_pk}")
	public ResponseEntity<Map<String, Object>> selectDetailsBucket(@PathVariable("bucket_pk") int bucket_pk) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		List<Bucket_detail_List_DTO> list;

		try {
			list = bucketDetailListService.selectDetailsBucket(bucket_pk);
			resultMap.put("BucketDetailList", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@GetMapping("/spot/{spot_pk}")
	public ResponseEntity<Map<String, Object>> selectDetailsSpot(@PathVariable("spot_pk") int spot_pk) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		List<Bucket_detail_List_DTO> list;

		try {
			list = bucketDetailListService.selectDetailsSpot(spot_pk);
			resultMap.put("BucketDetailList", list);
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
