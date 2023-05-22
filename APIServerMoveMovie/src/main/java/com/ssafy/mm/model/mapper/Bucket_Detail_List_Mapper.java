package com.ssafy.mm.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mm.model.Bucket_detail_List_DTO;

@Mapper
public interface Bucket_Detail_List_Mapper {
	
	public List<Bucket_detail_List_DTO> selectDetails() throws SQLException;
	public List<Bucket_detail_List_DTO> selectDetailsBucket(int bucket_pk) throws SQLException;
	public List<Bucket_detail_List_DTO> selectDetailsSpot(int spot_pk) throws SQLException;
	public void insertDetail(List<Bucket_detail_List_DTO> list) throws SQLException;
}
