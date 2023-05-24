package com.ssafy.mm.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mm.model.SpotInstanceDto;

@Mapper
public interface SpotInstanceMapper {
	public void insert(SpotInstanceDto spotInstanceDto) throws SQLException;
	public List<SpotInstanceDto> selectList(int spot_pk) throws SQLException;
}
