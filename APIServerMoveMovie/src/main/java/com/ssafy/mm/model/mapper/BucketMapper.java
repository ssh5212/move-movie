package com.ssafy.mm.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mm.model.BucketDto;

@Mapper
public interface BucketMapper {
	// 전체 리스트 출력
	public List<BucketDto> all_bucket();
//	select * from bucket;
	// 스팟이 포함된 리스트 출력
	public List<BucketDto> bucket_spot_pk(int spot_pk);
//	select * from bucket
//	where bucket_pk in (select distinct bucket_pk from bucket_detail_list 
//	where spot_pk = (select * from spot where spot_pk = 16386));
	
//	SELECT b.*
//	FROM bucket b
//	JOIN bucket_detail_list bdl ON b.bucket_pk = bdl.bucket_pk
//	JOIN spot s ON bdl.spot_pk = s.spot_pk
//	WHERE s.spot_pk = #{spot_pk}
	// 하트가 많은순
	public List<BucketDto> bucket_order_heart();

	// 하트 추가
	public void bucket_heart_plus(int bucket_pk);
	
	// 버킷 만들기
	public void bucket_create(BucketDto bucketDto);
	
	// 버킷 삭제
	public void bucket_delete(int bucket_pk);
	
	// 버킷 수정?
//	public void bucket_modify(Map<String, String> map);
}
