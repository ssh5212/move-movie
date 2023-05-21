package com.ssafy.mm.model.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mm.model.UserDto;
import com.ssafy.mm.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDto login(UserDto userdto) throws Exception {
		if (userdto.getUser_email() == null || userdto.getUser_pw() == null)
			return null;
		return sqlSession.getMapper(UserMapper.class).login(userdto);
	}

	@Override
	public UserDto userInfo(String user_email) throws Exception {
		return sqlSession.getMapper(UserMapper.class).userInfo(user_email);
	}

	@Override
	public void saveRefreshToken(String user_email, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_email", user_email);
		map.put("refreshtoken", refreshToken);
		sqlSession.getMapper(UserMapper.class).saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String user_email) throws Exception {
		return sqlSession.getMapper(UserMapper.class).getRefreshToken(user_email);
	}

	@Override
	public void deleteRefreshToken(String user_email) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_email", user_email);
		map.put("refreshtoken", null);
		sqlSession.getMapper(UserMapper.class).deleteRefreshToken(map);
	}

	@Override
	public void register(UserDto userdto) throws Exception {
		sqlSession.getMapper(UserMapper.class).register(userdto);
	}

	@Override
	public void edit(UserDto userdto) throws Exception {
		sqlSession.getMapper(UserMapper.class).edit(userdto);
		
	}

}
