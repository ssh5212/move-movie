package com.ssafy.mm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mm.model.Request_bucket_create_DTO;
import com.ssafy.mm.model.SidoGugunCodeDto;
import com.ssafy.mm.model.SpotDto;
import com.ssafy.mm.model.SpotInstanceDto;
import com.ssafy.mm.model.UserDto;
import com.ssafy.mm.model.service.SpotService;

@RestController
@RequestMapping("/spot")
//@CrossOrigin(origins = "*", allowCredentials = "true")
public class SpotController {

	public static final Logger logger = LoggerFactory.getLogger(SpotController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private SpotService spotService;

	@Value("${file.Path.spotfile}")
	private String uploadPath;

	@Value("${request.Path.spotfile.db}")
	private String spotfilerequest;

	@GetMapping("/spot")
	public ResponseEntity<Map<String, Object>> all_spot() {
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
	public ResponseEntity<Map<String, Object>> find_title_spot(
			@PathVariable("spot_movie_title") String spot_movie_title) {
		System.out.println(spot_movie_title);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			List<SpotDto> list = spotService.find_title_spot(spot_movie_title);
			System.out.println("list " + list);
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

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> register(@RequestPart(name = "SpotDto") SpotDto spotDto,
			@RequestPart(name = "file", required = false) MultipartFile file) {

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;

		String filePath = "";
		String filename = "";

		// 파일 저장
		try {
			filename = file.getOriginalFilename();
			filePath = uploadPath + File.separator + filename;
			File dest = new File(filePath);
			file.transferTo(dest);
			System.out.println(filePath);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		String fileRequestPath = spotfilerequest + filename;
		
		spotDto.setSpot_img_src(fileRequestPath);
		System.out.println("+_+_+_+_+_+_+_+");
		System.out.println(spotDto);
		System.out.println(fileRequestPath);
		
		
		System.out.println("+_+_+_+_+_+_+_+");
		try {
			spotService.register(spotDto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("스폿 등록 실패 : ", e);
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// spot_create
//	@PostMapping("/spot")
//	public ResponseEntity<Map<String, Object>> bucket_create(@RequestBody Request_bucket_create_DTO bucket_info) {
//		Map<String, Object> resultMap = new HashMap<>();
//		HttpStatus status = null;
//		System.out.println(bucket_info);
//		try {
//			bucketService.bucket_create(bucket_info);
//			resultMap.put("message", SUCCESS);
//			status = HttpStatus.OK;
//		} catch (Exception e) {
//			e.printStackTrace();
//			resultMap.put("message", e.getMessage());
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//		return new ResponseEntity<Map<String, Object>>(resultMap, status);
//	}

	// 지역으로 스팟 찾기
	@GetMapping("/spot_area/{gugun_code}")
	public ResponseEntity<Map<String, Object>> gugunList(@PathVariable("gugun_code") String gugun_code)
			throws Exception {
		System.out.println("start gugunList");
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			List<SpotDto> list = spotService.find_sido_gugun_spot(gugun_code);
			System.out.println("list" + list);

			resultMap.put("spots", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@GetMapping("/{spot_pk}")
	public ResponseEntity<Map<String, Object>> spotOne(@PathVariable("spot_pk") int spot_pk) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			SpotDto spotDto = spotService.spotOne(spot_pk);
			resultMap.put("spot", spotDto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

//	@PostMapping("/spot_area")
//	public ResponseEntity<Map<String, Object>> find_title_spot(@RequestBody int sido_code,
//			@RequestBody int gugun_code) {
//		Map<String, Object> resultMap = new HashMap<>();
//		HttpStatus status = null;
//
//		try {
//			List<SpotDto> list = spotService.find_sido_gugun_spot(sido_code, gugun_code);
//			resultMap.put("spots", list);
//			resultMap.put("message", SUCCESS);
//			status = HttpStatus.OK;
//		} catch (SQLException e) {
//			resultMap.put("message", FAIL);
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//
//		return new ResponseEntity<Map<String, Object>>(resultMap, status);
//	}

	@PutMapping("/spot")
	public ResponseEntity<Map<String, Object>> modify_spot(@RequestBody SpotDto spotdto) {
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
	public ResponseEntity<Map<String, Object>> delete_spot(@RequestBody SpotDto spotdto) {
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

	@GetMapping("/sido")
	public ResponseEntity<Map<String, Object>> sido() throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			List<SidoGugunCodeDto> list = spotService.getSido();
			resultMap.put("spots", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@GetMapping("/gugun/{sido}")
	public ResponseEntity<Map<String, Object>> gugun(@PathVariable("sido") String sido) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			List<SidoGugunCodeDto> list = spotService.getGugun(sido);
			System.out.println("list" + list);

			resultMap.put("spots", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 스폿 instance 가져오기
	@GetMapping("/spot_instance/{spotNum}")
	public ResponseEntity<Map<String, Object>> get_instance(@PathVariable("spotNum") int spotNum) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			List<SpotInstanceDto> list = spotService.getSpotInstance(spotNum);
			System.out.println("list" + list);

			resultMap.put("spots", list);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 스폿 instance 작성
//	@PostMapping("/spot_instance")
//	public ResponseEntity<Map<String, Object>> set_instance(@PathVariable("sido") String sido) throws Exception {
//		Map<String, Object> resultMap = new HashMap<>();
//		HttpStatus status = null;
//
//		try {
//			List<SpotInstanceDto> list = spotService.getGugun(sido);
//			System.out.println("list" + list);
//
//			resultMap.put("spots", list);
//			resultMap.put("message", SUCCESS);
//			status = HttpStatus.OK;
//		} catch (Exception e) {
//			resultMap.put("message", FAIL);
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//		return new ResponseEntity<Map<String, Object>>(resultMap, status);
//	}

}
