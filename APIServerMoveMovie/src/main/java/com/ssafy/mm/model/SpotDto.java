package com.ssafy.mm.model;

public class SpotDto {
	private int spot_pk;
	private String spot_name;
	private String spot_scene_desc;
	private String spot_img_src;
	private int spot_lat;
	private int spot_lon;
	private String spot_address;
	private String spot_road_address;
	private String spot_characters;
	private String spot_movie_title;
	private String spot_filming_seq;
	private int user_pk;
	private int sido_code;
	private int gugun_code;
	public int getSpot_pk() {
		return spot_pk;
	}
	public void setSpot_pk(int spot_pk) {
		this.spot_pk = spot_pk;
	}
	public String getSpot_name() {
		return spot_name;
	}
	public void setSpot_name(String spot_name) {
		this.spot_name = spot_name;
	}
	public String getSpot_scene_desc() {
		return spot_scene_desc;
	}
	public void setSpot_scene_desc(String spot_scene_desc) {
		this.spot_scene_desc = spot_scene_desc;
	}
	public String getSpot_img_src() {
		return spot_img_src;
	}
	public void setSpot_img_src(String spot_img_src) {
		this.spot_img_src = spot_img_src;
	}
	public int getSpot_lat() {
		return spot_lat;
	}
	public void setSpot_lat(int spot_lat) {
		this.spot_lat = spot_lat;
	}
	public int getSpot_lon() {
		return spot_lon;
	}
	public void setSpot_lon(int spot_lon) {
		this.spot_lon = spot_lon;
	}
	public String getSpot_address() {
		return spot_address;
	}
	public void setSpot_address(String spot_address) {
		this.spot_address = spot_address;
	}
	public String getSpot_road_address() {
		return spot_road_address;
	}
	public void setSpot_road_address(String spot_road_address) {
		this.spot_road_address = spot_road_address;
	}
	public String getSpot_characters() {
		return spot_characters;
	}
	public void setSpot_characters(String spot_characters) {
		this.spot_characters = spot_characters;
	}
	public String getSpot_movie_title() {
		return spot_movie_title;
	}
	public void setSpot_movie_title(String spot_movie_title) {
		this.spot_movie_title = spot_movie_title;
	}
	public String getSpot_filming_seq() {
		return spot_filming_seq;
	}
	public void setSpot_filming_seq(String spot_filming_seq) {
		this.spot_filming_seq = spot_filming_seq;
	}
	public int getUser_pk() {
		return user_pk;
	}
	public void setUser_pk(int user_pk) {
		this.user_pk = user_pk;
	}
	public int getSido_code() {
		return sido_code;
	}
	public void setSido_code(int sido_code) {
		this.sido_code = sido_code;
	}
	public int getGugun_code() {
		return gugun_code;
	}
	public void setGugun_code(int gugun_code) {
		this.gugun_code = gugun_code;
	}
	@Override
	public String toString() {
		return "SpotDto [spot_pk=" + spot_pk + ", spot_name=" + spot_name + ", spot_scene_desc=" + spot_scene_desc
				+ ", spot_img_src=" + spot_img_src + ", spot_lat=" + spot_lat + ", spot_lon=" + spot_lon
				+ ", spot_address=" + spot_address + ", spot_road_address=" + spot_road_address + ", spot_characters="
				+ spot_characters + ", spot_movie_title=" + spot_movie_title + ", spot_filming_seq=" + spot_filming_seq
				+ ", user_pk=" + user_pk + ", sido_code=" + sido_code + ", gugun_code=" + gugun_code + "]";
	}
	
	
}
