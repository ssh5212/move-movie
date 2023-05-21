package com.ssafy.mm.model;

public class BucketDto {
	private int bucket_pk;
	private int bucket_heart;
	private int user_pk;
	private String bucket_title;
	private String bucket_content;

	public int getBucket_pk() {
		return bucket_pk;
	}

	public void setBucket_pk(int bucket_pk) {
		this.bucket_pk = bucket_pk;
	}

	public int getBucket_heart() {
		return bucket_heart;
	}

	public void setBucket_heart(int bucket_heart) {
		this.bucket_heart = bucket_heart;
	}

	public int getUser_pk() {
		return user_pk;
	}

	public void setUser_pk(int user_pk) {
		this.user_pk = user_pk;
	}

	public String getBucket_title() {
		return bucket_title;
	}

	public void setBucket_title(String bucket_title) {
		this.bucket_title = bucket_title;
	}

	public String getBucket_content() {
		return bucket_content;
	}

	public void setBucket_content(String bucket_content) {
		this.bucket_content = bucket_content;
	}

	@Override
	public String toString() {
		return "BucketDto [bucket_pk=" + bucket_pk + ", bucket_heart=" + bucket_heart + ", user_pk=" + user_pk
				+ ", bucket_title=" + bucket_title + ", bucket_content=" + bucket_content + "]";
	}

}
