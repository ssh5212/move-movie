package com.ssafy.mm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mm.model.UserDto;
import com.ssafy.mm.model.service.JwtServiceImpl;
import com.ssafy.mm.model.service.UserService;

import io.swagger.annotations.ApiParam;



@RestController
@RequestMapping("/user")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	private UserService userService;
	
    @Value("${file.Path.profile}")
    private String uploadPath;
    
    @Value("${request.Path.profile.db}")
	private String profilerequest;
    
	//로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody UserDto userdto){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		System.out.println(userdto);
		try {
			UserDto loginUser = userService.login(userdto);
			if (loginUser != null) {
				String accessToken = jwtService.createAccessToken("user_email", loginUser.getUser_email()); // key, data
				String refreshToken = jwtService.createRefreshToken("user_email", loginUser.getUser_email()); // key, data
				userService.saveRefreshToken(userdto.getUser_email(), refreshToken);
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.OK;

			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
				System.out.println("else");

				System.out.println(status);
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;

		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
//	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{user_email}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("user_email") @ApiParam(value = "인증할 회원의 아이디.", required = true) String user_email,
			HttpServletRequest request) {
		logger.info("userinfo : user_email : {} ", user_email);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserDto userDto = userService.userInfo(user_email);
				resultMap.put("userInfo", userDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
//	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
	@GetMapping("/logout/{user_email}")
	public ResponseEntity<?> removeToken(@PathVariable("user_email") String user_email) {
		System.out.println(user_email);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleteRefreshToken(user_email);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}

//	@ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserDto userdto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, userdto);
		if (jwtService.checkToken(token)) {
			if (token.equals(userService.getRefreshToken(userdto.getUser_email()))) {
				String accessToken = jwtService.createAccessToken("userid", userdto.getUser_email());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
//	@RequestBody UserDto UserDto,  @RequestParam("file") MultipartFile file
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> register(@RequestPart(name="UserDto") UserDto userDto,  @RequestPart(name = "file" , required = false) MultipartFile file){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String filePath = "";
		String filename = "";
		//이미지 파일 local에 저장하기
        try {
        	filename = userDto.getUser_email() +file.getOriginalFilename();
        	filePath = uploadPath + File.separator + filename;
        	File dest = new File(filePath);
			file.transferTo(dest);
			System.out.println(filePath);
			logger.debug("File uploaded successfully: {}", file.getOriginalFilename());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
        String fileRequestPath = profilerequest + filename;
        
		System.out.println(userDto);
		userDto.setUser_profile_img_src(fileRequestPath);
		try {
			userService.register(userDto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("회원가입 실패 : ", e);
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	
	// 수정
	@PostMapping("/edit")
	public ResponseEntity<?> edit(@RequestBody UserDto userdto){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		System.out.println("에디트 나오니?");
		
		System.out.println(userdto);
		try {
			userService.edit(userdto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("회원정보 수정 실패 : ", e);
			resultMap.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}

