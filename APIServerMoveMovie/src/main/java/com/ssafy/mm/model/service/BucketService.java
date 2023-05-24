package com.ssafy.mm.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mm.model.BucketDto;
import com.ssafy.mm.model.Request_bucket_create_DTO;

@Service
public interface BucketService {

	// 전체 리스트 출력
	public List<BucketDto> all_bucket() throws Exception;

	public List<BucketDto> bucket_spot_pk(int spot_pk) throws Exception;

	public List<BucketDto> bucket_order_heart() throws Exception;
	
	public List<BucketDto> bucket_user_pk(int user_pk) throws Exception;;

	public void bucket_heart_plus(int bucket_pk) throws Exception;

	public void bucket_create(Request_bucket_create_DTO bucket_info) throws Exception;

	public void bucket_delete(int bucket_pk) throws Exception;
	
	public BucketDto bucket_one(int bucket_pk) throws Exception;
	// 아직 구현 x
//	public void bucket_modify(Map<String, String> map);
}
