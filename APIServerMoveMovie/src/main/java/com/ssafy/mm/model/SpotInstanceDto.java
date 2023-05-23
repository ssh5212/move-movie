package com.ssafy.mm.model;

public class SpotInstanceDto {
	private int spot_instance_pk;
	private String spot_instance_title;
	private int spot_instance_heart;
	private String spot_instance_content;
	private String spot_instance_img_src;
	private int spot_pk;
	private int user_pk;
	public int getSpot_instance_pk() {
		return spot_instance_pk;
	}
	public void setSpot_instance_pk(int spot_instance_pk) {
		this.spot_instance_pk = spot_instance_pk;
	}
	public String getSpot_instance_title() {
		return spot_instance_title;
	}
	public void setSpot_instance_title(String spot_instance_title) {
		this.spot_instance_title = spot_instance_title;
	}
	public int getSpot_instance_heart() {
		return spot_instance_heart;
	}
	public void setSpot_instance_heart(int spot_instance_heart) {
		this.spot_instance_heart = spot_instance_heart;
	}
	public String getSpot_instance_content() {
		return spot_instance_content;
	}
	public void setSpot_instance_content(String spot_instance_content) {
		this.spot_instance_content = spot_instance_content;
	}
	public String getSpot_instance_img_src() {
		return spot_instance_img_src;
	}
	public void setSpot_instance_img_src(String spot_instance_img_src) {
		this.spot_instance_img_src = spot_instance_img_src;
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
	@Override
	public String toString() {
		return "Spot_InstanceDto [spot_instance_pk=" + spot_instance_pk + ", spot_instance_title=" + spot_instance_title
				+ ", spot_instance_heart=" + spot_instance_heart + ", spot_instance_content=" + spot_instance_content
				+ ", spot_instance_img_src=" + spot_instance_img_src + ", spot_pk=" + spot_pk + ", user_pk=" + user_pk
				+ "]";
	}

	
}
