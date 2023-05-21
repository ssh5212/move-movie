package com.ssafy.mm.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.mm.model.SpotDto;

public interface SpotService {
	public List<SpotDto> all_spot() throws SQLException;
	public List<SpotDto> find_title_spot(String spot_movie_title) throws SQLException;
	public List<SpotDto> find_sido_gugun_spot(int sido_code, int gugun_code) throws SQLException;
	public void modify_spot(SpotDto spotdto) throws SQLException;
	public void delete_spot(SpotDto spotdto) throws SQLException;
}
