package com.ssafy.mm.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mm.model.BucketDto;

@Mapper
public interface BucketMapper {
	// 전체 리스트 출력
	public List<BucketDto> all_bucket();
	
	public List<BucketDto> bucket_spot_pk(int spot_pk);

	public List<BucketDto> bucket_user_pk(int user_pk);
	
	// 하트가 많은순
	public List<BucketDto> bucket_order_heart();
	
	public BucketDto bucket_one(int bucket_pk);
	
	// 하트 추가
	public void bucket_heart_plus(int bucket_pk);
	
	// 버킷 만들기
	public void bucket_create(BucketDto bucketDto);
	
	// 버킷 삭제
	public void bucket_delete(int bucket_pk);
	
	// 버킷 수정?
//	public void bucket_modify(Map<String, String> map);
}
