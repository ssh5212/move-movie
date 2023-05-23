package com.ssafy.mm.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mm.model.my_bucket_list_DTO;

public interface MyBucketListService {
	public void insertList(List<my_bucket_list_DTO> list) throws Exception;

	public List<my_bucket_list_DTO> select() throws Exception;

	public List<my_bucket_list_DTO> select(int user_pk, int bucket_pk) throws Exception;

//	public void updateChecked(int user_pk, int spot_pk, int bucket_pk, int checked) throws Exception;

	public void delete(int user_pk, int spot_pk, int bucket_pk) throws Exception;
	
	public void updateChecked(int user_pk, int spot_pk, int checked) throws Exception;
	public my_bucket_list_DTO selectcheck(int user_pk, int spot_pk) throws SQLException;
}
