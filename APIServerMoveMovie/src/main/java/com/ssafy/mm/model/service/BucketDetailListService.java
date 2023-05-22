package com.ssafy.mm.model.service;

import java.util.List;

import com.ssafy.mm.model.Bucket_detail_List_DTO;

public interface BucketDetailListService {
	public List<Bucket_detail_List_DTO> selectDetails() throws Exception;
	public List<Bucket_detail_List_DTO> selectDetailsBucket(int bucket_pk) throws Exception;
	public List<Bucket_detail_List_DTO> selectDetailsSpot(int spot_pk) throws Exception;
	public void insertDetail(List<Bucket_detail_List_DTO> lists) throws Exception;
}
