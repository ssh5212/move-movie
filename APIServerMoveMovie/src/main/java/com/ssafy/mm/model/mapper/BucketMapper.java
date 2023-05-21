package com.ssafy.mm.model.mapper;

public interface BucketMapper {
	// 전체 리스트 출력
//	select * from bucket;
	// 스팟이 포함된 리스트 출력
//	select * from bucket
//	where bucket_pk in (select distinct bucket_pk from bucket_detail_list 
//	where spot_pk = (select * from spot where spot_pk = 16386));
	
//	SELECT b.*
//	FROM bucket b
//	JOIN bucket_detail_list bdl ON b.bucket_pk = bdl.bucket_pk
//	JOIN spot s ON bdl.spot_pk = s.spot_pk
//	WHERE s.spot_pk = #{spot_pk}
	// 하트가 많은순
	
	// 하트 추가
	
	// 버킷 만들기
	
	// 버킷 삭제
	
	// 버킷 수정?
}
