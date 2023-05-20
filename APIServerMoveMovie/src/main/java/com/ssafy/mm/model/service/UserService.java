package com.ssafy.mm.model.service;

import com.ssafy.mm.model.UserDto;

public interface UserService {
	
	public UserDto login(UserDto userdto) throws Exception;
	public UserDto userInfo(String user_email) throws Exception;
	public void saveRefreshToken(String user_email, String refreshToken) throws Exception;
	public Object getRefreshToken(String user_email) throws Exception;
	public void deleteRefreshToken(String user_email) throws Exception;
	public void register(UserDto userdto) throws Exception;
}
