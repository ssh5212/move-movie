package com.ssafy.mm.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mm.model.SpotDto;
import com.ssafy.mm.model.mapper.SpotMapper;

@Service
public class SpotServiceImpl implements SpotService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SpotDto> all_spot() throws Exception {
		return sqlSession.getMapper(SpotMapper.class).all_spot();
	}

	@Override
	public List<SpotDto> find_title_spot(String spot_movie_title) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("spot_movie_title", spot_movie_title);
		return sqlSession.getMapper(SpotMapper.class).find_title_spot(map);
	}

	@Override
	public List<SpotDto> find_sido_gugun_spot(int sido_code, int gugun_code) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("sido_code", sido_code);
		map.put("gugun_code", gugun_code);
		return sqlSession.getMapper(SpotMapper.class).find_sido_gugun_spot(map);
	}

	@Override
	public void modify_spot(SpotDto spotdto) throws Exception {
		sqlSession.getMapper(SpotMapper.class).modify_spot(spotdto);
	}

	@Override
	public void delete_spot(SpotDto spotdto) throws Exception {
		sqlSession.getMapper(SpotMapper.class).delete_spot(spotdto);
	}
	


}
