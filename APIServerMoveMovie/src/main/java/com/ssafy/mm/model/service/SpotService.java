package com.ssafy.mm.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.mm.model.SidoGugunCodeDto;
import com.ssafy.mm.model.SpotDto;
import com.ssafy.mm.model.SpotInstanceDto;

public interface SpotService {
	public List<SpotDto> all_spot() throws Exception;
	public List<SpotDto> find_title_spot(String spot_movie_title) throws Exception;
	public List<SpotDto> find_sido_gugun_spot(String gugun_code) throws Exception;
	public void modify_spot(SpotDto spotdto) throws Exception;
	public void delete_spot(SpotDto spotdto) throws Exception;
	public List<SidoGugunCodeDto> getSido() throws Exception;
	public List<SidoGugunCodeDto> getGugun(String sido) throws Exception;
	public SpotDto spotOne(int spot_pk) throws Exception;
	public List<SpotInstanceDto> getSpotInstance(int spotNum) throws Exception;
	public void register(SpotDto spotDto) throws Exception;

}
