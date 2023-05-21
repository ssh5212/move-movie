package com.ssafy.mm.model;

public class GugunDto {
	private int gugun_code;
	private int sido_code;
	private String gugun_name;

	public int getGugun_code() {
		return gugun_code;
	}

	public void setGugun_code(int gugun_code) {
		this.gugun_code = gugun_code;
	}

	public int getSido_code() {
		return sido_code;
	}

	public void setSido_code(int sido_code) {
		this.sido_code = sido_code;
	}

	public String getGugun_name() {
		return gugun_name;
	}

	public void setGugun_name(String gugun_name) {
		this.gugun_name = gugun_name;
	}

	@Override
	public String toString() {
		return "GugunDto [gugun_code=" + gugun_code + ", sido_code=" + sido_code + ", gugun_name=" + gugun_name + "]";
	}

}
