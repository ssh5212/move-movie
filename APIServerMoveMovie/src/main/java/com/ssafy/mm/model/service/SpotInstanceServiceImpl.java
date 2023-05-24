package com.ssafy.mm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mm.model.SpotInstanceDto;
import com.ssafy.mm.model.mapper.SpotInstanceMapper;

@Service
public class SpotInstanceServiceImpl implements SpotInstanceService {
	
	private SpotInstanceMapper spotInstanceMapper;
	
	@Autowired
	SpotInstanceServiceImpl(SpotInstanceMapper spotInstanceMapper){
		this.spotInstanceMapper  = spotInstanceMapper;
	}
	
	@Override
	public void insert(SpotInstanceDto spotInstanceDto) throws Exception {
		spotInstanceMapper.insert(spotInstanceDto);
	}

	@Override
	public List<SpotInstanceDto> selectList(int spot_pk) throws Exception {
		return spotInstanceMapper.selectList(spot_pk);
	}

}
