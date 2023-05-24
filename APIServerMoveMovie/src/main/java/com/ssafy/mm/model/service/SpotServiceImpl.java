package com.ssafy.mm.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mm.model.SidoGugunCodeDto;
import com.ssafy.mm.model.SpotDto;
import com.ssafy.mm.model.SpotInstanceDto;
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
	@Transactional
	public List<SpotDto> find_title_spot(String spot_movie_title) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("들어오니");
		map.put("spot_movie_title", spot_movie_title);
//		System.out.println("map");
//		System.out.println(map);
		return sqlSession.getMapper(SpotMapper.class).find_title_spot(map);
	}

	@Override
	public List<SpotDto> find_sido_gugun_spot(String gugun_code) throws Exception {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		map.put("gugun_code", gugun_code);
		return sqlSession.getMapper(SpotMapper.class).find_sido_gugun_spot(gugun_code);
	}

	@Override
	public void modify_spot(SpotDto spotdto) throws Exception {
		sqlSession.getMapper(SpotMapper.class).modify_spot(spotdto);
	}

	@Override
	public void delete_spot(SpotDto spotdto) throws Exception {
		sqlSession.getMapper(SpotMapper.class).delete_spot(spotdto);
	}

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return sqlSession.getMapper(SpotMapper.class).getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugun(String sido) throws Exception {
		return sqlSession.getMapper(SpotMapper.class).getGugun(sido);
	}

	@Override
	public SpotDto spotOne(int spot_pk) throws Exception {
		return sqlSession.getMapper(SpotMapper.class).spotOne(spot_pk);
	}

	@Override
	public List<SpotInstanceDto> getSpotInstance(int spotNum) throws Exception {
		return sqlSession.getMapper(SpotMapper.class).getSpotInstance(spotNum);
	}

	@Override
	public void register(SpotDto spotDto) throws Exception {
		sqlSession.getMapper(SpotMapper.class).register(spotDto);
		
	}
	


}
