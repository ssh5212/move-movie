package com.ssafy.mm.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

public class ResponseUserDto {
	private int user_pk;
	private int user_exp;
	private int user_role;
	private String user_nickname;
	private String user_email;
	private String user_pw;
	private String user_name;
	private String register_time;
	MultipartFile file;

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
