package com.ssafy.mm.model;

public class Bucket_detail_List_DTO {
	private int bucket_pk;
	private int spot_pk;

	public int getBucket_pk() {
		return bucket_pk;
	}

	public void setBucket_pk(int bucket_pk) {
		this.bucket_pk = bucket_pk;
	}

	public int getSpot_pk() {
		return spot_pk;
	}

	public void setSpot_pk(int spot_pk) {
		this.spot_pk = spot_pk;
	}

	@Override
	public String toString() {
		return "Bucket_detail_List_DTO [bucket_pk=" + bucket_pk + ", spot_pk=" + spot_pk + "]";
	}

}
