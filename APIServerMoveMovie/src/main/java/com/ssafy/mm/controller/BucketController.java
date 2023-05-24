package com.ssafy.mm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mm.model.BucketDto;
import com.ssafy.mm.model.Request_bucket_create_DTO;
import com.ssafy.mm.model.service.BucketService;

@RestController
@RequestMapping("/bucket")
public class BucketController {

	public static final Logger logger = LoggerFactory.getLogger(BucketController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BucketService bucketService;

	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> all_bucket() {
		System.out.println("all");
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		List<BucketDto> list;
		try {
			list = bucketService.all_bucket();
			resultMap.put("BucketList", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// bucket_spot_pk
	@GetMapping("/{spot_pk}")
	public ResponseEntity<Map<String, Object>> bucket_spot_pk(@PathVariable("spot_pk") int spot_pk) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		List<BucketDto> list;

		try {
			list = bucketService.bucket_spot_pk(spot_pk);
			resultMap.put("BucketList", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("byuser/{user_pk}")
	public ResponseEntity<Map<String, Object>> bucket_user_pk(@PathVariable("user_pk") int user_pk) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		List<BucketDto> list;

		try {
			list = bucketService.bucket_user_pk(user_pk);
			resultMap.put("BucketList", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// bucket_order_heart
	@GetMapping("/bucket_heart_desc")
	public ResponseEntity<Map<String, Object>> bucket_order_heart() {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		List<BucketDto> list;

		try {
			list = bucketService.bucket_order_heart();
			resultMap.put("BucketList", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// bucket_heart_plus
	@GetMapping("/heart_plus/{bucket_pk}")
	public ResponseEntity<Map<String, Object>> bucket_heart_plus(@PathVariable("bucket_pk") int bucket_pk) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		List<BucketDto> list;

		try {
			bucketService.bucket_heart_plus(bucket_pk);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// bucket_create
	@PostMapping("/bucket_create")
	public ResponseEntity<Map<String, Object>> bucket_create(@RequestBody Request_bucket_create_DTO bucket_info) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		System.out.println(bucket_info);
		try {
			bucketService.bucket_create(bucket_info);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// bucket_delete
	@DeleteMapping("/{bucket_pk}")
	public ResponseEntity<Map<String, Object>> bucket_delete(@PathVariable("bucket_pk") int bucket_pk) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			bucketService.bucket_delete(bucket_pk);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// bucket_pk
		@GetMapping("/bucket/{bucket_pk}")
		public ResponseEntity<Map<String, Object>> bucket_pk(@PathVariable("bucket_pk") int bucket_pk) {
			Map<String, Object> resultMap = new HashMap<>();
			HttpStatus status = null;

			try {
				BucketDto dto = bucketService.bucket_one(bucket_pk);
				resultMap.put("Bucket", dto);
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
