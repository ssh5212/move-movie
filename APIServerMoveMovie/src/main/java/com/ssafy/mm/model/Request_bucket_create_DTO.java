package com.ssafy.mm.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class Request_bucket_create_DTO {
	// bucket
	BucketDto bucketDto;
	// spotlist
	List<SpotDto> Spots;

	public BucketDto getBucketDto() {
		return bucketDto;
	}

	public void setBucketDto(BucketDto bucketDto) {
		this.bucketDto = bucketDto;
	}

	public List<SpotDto> getSpots() {
		return Spots;
	}

	public void setSpots(List<SpotDto> spots) {
		Spots = spots;
	}

	@Override
	public String toString() {
		return "Request_bucket_create_DTO [bucketDto=" + bucketDto + ", Spots=" + Spots + "]";
	}

}
