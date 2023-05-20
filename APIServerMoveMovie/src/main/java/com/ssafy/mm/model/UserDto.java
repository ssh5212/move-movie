package com.ssafy.mm.model;

public class UserDto {

	private int user_pk;
	private int user_exp;
	private int user_role;
	private String user_nickname;
	private String user_email;
	private String user_pw;
	private String user_name;
	private String register_time;
	private String user_profile_img_src;

	public int getUser_pk() {
		return user_pk;
	}

	public void setUser_pk(int user_pk) {
		this.user_pk = user_pk;
	}

	public int getUser_exp() {
		return user_exp;
	}

	public void setUser_exp(int user_exp) {
		this.user_exp = user_exp;
	}

	public int getUser_role() {
		return user_role;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getRegister_time() {
		return register_time;
	}

	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}

	public String getUser_profile_img_src() {
		return user_profile_img_src;
	}

	public void setUser_profile_img_src(String user_profile_img_src) {
		this.user_profile_img_src = user_profile_img_src;
	}

	@Override
	public String toString() {
		return "UserDto [user_pk=" + user_pk + ", user_exp=" + user_exp + ", user_role=" + user_role
				+ ", user_nickname=" + user_nickname + ", user_email=" + user_email + ", user_pw=" + user_pw
				+ ", user_name=" + user_name + ", register_time=" + register_time + ", user_profile_img_src="
				+ user_profile_img_src + "]";
	}

	
}
