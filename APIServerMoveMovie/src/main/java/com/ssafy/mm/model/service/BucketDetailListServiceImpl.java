package com.ssafy.mm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mm.model.Bucket_detail_List_DTO;
import com.ssafy.mm.model.mapper.Bucket_Detail_List_Mapper;

@Service
public class BucketDetailListServiceImpl implements BucketDetailListService {

	private static Bucket_Detail_List_Mapper Mapper;

	@Autowired
	public BucketDetailListServiceImpl(Bucket_Detail_List_Mapper Mapper) {
		this.Mapper = Mapper;
	}

	@Override
	public List<Bucket_detail_List_DTO> selectDetails() throws Exception {
		return Mapper.selectDetails();
	}

	@Override
	public List<Bucket_detail_List_DTO> selectDetailsBucket(int bucket_pk) throws Exception {
		return Mapper.selectDetailsBucket(bucket_pk);
	}

	@Override
	public List<Bucket_detail_List_DTO> selectDetailsSpot(int spot_pk) throws Exception {
		return Mapper.selectDetailsSpot(spot_pk);
	}

	@Override
	public void insertDetail(List<Bucket_detail_List_DTO> lists) throws Exception {
		Mapper.insertDetail(lists);
	}

}
