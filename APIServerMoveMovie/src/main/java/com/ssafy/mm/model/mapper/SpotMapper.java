package com.ssafy.mm.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mm.model.SidoGugunCodeDto;
import com.ssafy.mm.model.SpotDto;
import com.ssafy.mm.model.SpotInstanceDto;

@Mapper
public interface SpotMapper {
	public List<SpotDto> all_spot() throws SQLException;
	public List<SpotDto> find_title_spot(Map<String, String> map) throws SQLException;
	public List<SpotDto> find_sido_gugun_spot(String gugun_code) throws SQLException;
	public void modify_spot(SpotDto spotdto) throws SQLException;
	public void delete_spot(SpotDto spotdto) throws SQLException;
	public List<SidoGugunCodeDto> getSido() throws SQLException;
	public List<SidoGugunCodeDto> getGugun(String sido) throws SQLException;
	public SpotDto spotOne(int spot_pk) throws SQLException;
	public List<SpotInstanceDto> getSpotInstance(int spotNum) throws SQLException;
	public void register(SpotDto spotDto) throws SQLException;
}
