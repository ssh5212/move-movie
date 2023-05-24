package com.ssafy.mm.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ssafy.mm.model.BucketDto;
import com.ssafy.mm.model.Bucket_detail_List_DTO;
import com.ssafy.mm.model.Request_bucket_create_DTO;
import com.ssafy.mm.model.SpotDto;
import com.ssafy.mm.model.my_bucket_list_DTO;
import com.ssafy.mm.model.mapper.BucketMapper;
import com.ssafy.mm.model.mapper.Bucket_Detail_List_Mapper;
import com.ssafy.mm.model.mapper.My_Bucket_List_Mapper;


@Service
public class BucketServiceImpl implements BucketService {

	private BucketMapper bucketMapper;
	private Bucket_Detail_List_Mapper bucketDetailMapper;
	private My_Bucket_List_Mapper bucketMyListMapper;

	@Autowired
	public BucketServiceImpl(BucketMapper bucketMapper, Bucket_Detail_List_Mapper bucketDetailMapper,
			My_Bucket_List_Mapper bucketMyListMapper) throws Exception {
		this.bucketMapper = bucketMapper;
		this.bucketDetailMapper = bucketDetailMapper;
		this.bucketMyListMapper = bucketMyListMapper;
	}

	@Override
	public List<BucketDto> all_bucket() throws Exception {
		return bucketMapper.all_bucket();
	}

	@Override
	public List<BucketDto> bucket_spot_pk(int spot_pk) throws Exception {
		return bucketMapper.bucket_spot_pk(spot_pk);
	}

	@Override
	public List<BucketDto> bucket_order_heart() throws Exception {
		return bucketMapper.bucket_order_heart();
	}

	@Override
	public void bucket_heart_plus(int bucket_pk) throws Exception {
		bucketMapper.bucket_heart_plus(bucket_pk);
	}

	@Override
	@Transactional
	public void bucket_create(Request_bucket_create_DTO bucket_info) throws Exception {
		BucketDto bucket = bucket_info.getBucketDto();
		List<SpotDto> spots = bucket_info.getSpots();

		// 버킷 추가
		bucketMapper.bucket_create(bucket);
		//bucket 추가후 bucket.bucket_pk 에 해당 PK가 들어감
		
		
		// bucket_detail_list 추가
		List<Bucket_detail_List_DTO> detail_list = new ArrayList<Bucket_detail_List_DTO>();
		for (SpotDto spotDto : spots) {
			detail_list.add(new Bucket_detail_List_DTO(bucket.getBucket_pk(), spotDto.getSpot_pk()));
		}
		bucketDetailMapper.insertDetail(detail_list);

		// my_bucket_list 에도 추가
		// bucket_pk, spot_pk, user_pk
		List<my_bucket_list_DTO> myBucketList = new ArrayList();
		for (SpotDto spotDto : spots) {
			myBucketList
					.add(new my_bucket_list_DTO(bucket.getBucket_pk(), spotDto.getSpot_pk(), bucket.getUser_pk(), 0));
		}
		bucketMyListMapper.insertList(myBucketList);
	}

	@Override
	public void bucket_delete(int bucket_pk) throws Exception {
		bucketMapper.bucket_delete(bucket_pk);
	}

	@Override
	public BucketDto bucket_one(int bucket_pk) throws Exception {
		return bucketMapper.bucket_one(bucket_pk);
	}

	@Override
	public List<BucketDto> bucket_user_pk(int user_pk) throws Exception {
		return bucketMapper.bucket_user_pk(user_pk);
	}

}
