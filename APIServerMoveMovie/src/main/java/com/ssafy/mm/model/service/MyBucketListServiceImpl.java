package com.ssafy.mm.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mm.model.my_bucket_list_DTO;
import com.ssafy.mm.model.mapper.My_Bucket_List_Mapper;

@Service
public class MyBucketListServiceImpl implements MyBucketListService {

	private static My_Bucket_List_Mapper mapper;
	
	public MyBucketListServiceImpl(My_Bucket_List_Mapper mapper){
		this.mapper = mapper;
	}
	
	@Override
	public void insertList(List<my_bucket_list_DTO> list) throws Exception {
		mapper.insertList(list);
	}

	@Override
	public List<my_bucket_list_DTO> select() throws Exception {
		return mapper.select();
	}

	@Override
	public List<my_bucket_list_DTO> select(int user_pk, int bucket_pk) throws Exception {
		return mapper.select(user_pk, bucket_pk);
	}

	@Override
	public void updateChecked(int user_pk, int spot_pk, int bucket_pk, int checked) throws Exception {
		mapper.updateChecked(user_pk, spot_pk, bucket_pk, checked);
	}

	@Override
	public void delete(int user_pk, int spot_pk, int bucket_pk) throws Exception {
		mapper.delete(user_pk, spot_pk, bucket_pk);
	}

}
