package com.ssafy.mm.model.service;

import java.util.List;

import com.ssafy.mm.model.SpotInstanceDto;

public interface SpotInstanceService {
	public void insert(SpotInstanceDto spotInstanceDto) throws Exception;
	public List<SpotInstanceDto> selectList(int spot_pk) throws Exception;
}
