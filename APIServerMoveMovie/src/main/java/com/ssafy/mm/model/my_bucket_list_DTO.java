package com.ssafy.mm.model;

public class my_bucket_list_DTO {
	private int bucket_pk;
	private int spot_pk;
	private int user_pk;
	private int checked;

	public my_bucket_list_DTO(int bucket_pk, int spot_pk, int user_pk, int checked) {
		super();
		this.bucket_pk = bucket_pk;
		this.spot_pk = spot_pk;
		this.user_pk = user_pk;
		this.checked = checked;
	}

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

	public int getUser_pk() {
		return user_pk;
	}

	public void setUser_pk(int user_pk) {
		this.user_pk = user_pk;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "my_bucket_list_DTO [bucket_pk=" + bucket_pk + ", spot_pk=" + spot_pk + ", user_pk=" + user_pk
				+ ", checked=" + checked + "]";
	}

}
