package com.ssafy.mm.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mm.model.my_bucket_list_DTO;

@Mapper
public interface My_Bucket_List_Mapper {
	// list insert
	// select
	// select user_pk bucket_pk
	// update user_pk, spot_pk, bucket_pk checked
	// delete user_pk, spot_pk, bucket_pk

	public void insertList(List<my_bucket_list_DTO> list) throws SQLException;

	public List<my_bucket_list_DTO> select() throws SQLException;

	public List<my_bucket_list_DTO> selectUserBucket(my_bucket_list_DTO dto) throws SQLException;
	
//	public void updateChecked(int user_pk, int spot_pk, int bucket_pk, int checked) throws SQLException;

	public void delete(int user_pk, int spot_pk, int bucket_pk) throws SQLException;
	
	
	public void updateChecked(my_bucket_list_DTO dto) throws SQLException;
	public List<my_bucket_list_DTO> selectcheck(my_bucket_list_DTO dto) throws SQLException;
}
