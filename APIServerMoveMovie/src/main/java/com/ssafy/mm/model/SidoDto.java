package com.ssafy.mm.model;

public class SidoDto {
	private int sido_code;
	private String sido_name;

	public int getSido_code() {
		return sido_code;
	}

	public void setSido_code(int sido_code) {
		this.sido_code = sido_code;
	}

	public String getSido_name() {
		return sido_name;
	}

	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}

	@Override
	public String toString() {
		return "SidoDto [sido_code=" + sido_code + ", sido_name=" + sido_name + "]";
	}

}
