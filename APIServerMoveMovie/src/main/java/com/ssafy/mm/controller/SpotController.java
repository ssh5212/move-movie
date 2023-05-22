package com.ssafy.mm.controller;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mm.model.SpotDto;
import com.ssafy.mm.model.service.SpotService;

@RestController
@RequestMapping("/spot")
public class SpotController {
	
	public static final Logger logger = LoggerFactory.getLogger(SpotController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private SpotService spotService;
	
	@GetMapping("/spot")
	public ResponseEntity<Map<String, Object>> all_spot(){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			List<SpotDto> list = spotService.all_spot();
			resultMap.put("spots", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/spot/{spot_movie_title}")
	public ResponseEntity<Map<String, Object>> find_title_spot(@PathVariable("spot_movie_title") String spot_movie_title){
		System.out.println(spot_movie_title);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			List<SpotDto> list = spotService.find_title_spot(spot_movie_title);
			System.out.println("list " + list );
			resultMap.put("spots", list);
			resultMap.put("message", SUCCESS);
			System.out.println(resultMap);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/spot_area")
	public ResponseEntity<Map<String, Object>> find_title_spot(@RequestBody int sido_code, @RequestBody int gugun_code){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			List<SpotDto> list = spotService.find_sido_gugun_spot(sido_code, gugun_code);
			resultMap.put("spots", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PutMapping("/spot")
	public ResponseEntity<Map<String, Object>> modify_spot(@RequestBody SpotDto spotdto){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			spotService.modify_spot(spotdto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@DeleteMapping("/spot")
	public ResponseEntity<Map<String, Object>> delete_spot(@RequestBody SpotDto spotdto){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			spotService.delete_spot(spotdto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}
