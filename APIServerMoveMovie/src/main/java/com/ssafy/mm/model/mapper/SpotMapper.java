package com.ssafy.mm.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mm.model.SidoGugunCodeDto;
import com.ssafy.mm.model.SpotDto;

@Mapper
public interface SpotMapper {
	public List<SpotDto> all_spot() throws SQLException;
	public List<SpotDto> find_title_spot(Map<String, String> map) throws SQLException;
	public List<SpotDto> find_sido_gugun_spot(Map<String, Integer> map) throws SQLException;
	public void modify_spot(SpotDto spotdto) throws SQLException;
	public void delete_spot(SpotDto spotdto) throws SQLException;
	public List<SidoGugunCodeDto> getSido() throws SQLException;
	public List<SidoGugunCodeDto> getGugun(String sido) throws SQLException;
}
