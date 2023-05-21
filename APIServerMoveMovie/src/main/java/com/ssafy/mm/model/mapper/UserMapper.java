package com.ssafy.mm.model.mapper;

import java.sql.SQLException;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mm.model.UserDto;


@Mapper
public interface UserMapper {
	public UserDto login(UserDto userdto) throws SQLException;
	public UserDto userInfo(String user_email) throws SQLException;
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String user_email) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
	public void register(UserDto userdto) throws Exception;
	public void edit(UserDto userdto) throws Exception;
}
