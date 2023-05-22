package com.ssafy.mm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class SidoGugunCodeDto {

	@ApiModelProperty(value = "시도코드")
	private String sido_code;
	@ApiModelProperty(value = "시도이름")
	private String sido_name;
	@ApiModelProperty(value = "구군코드")
	private String gugun_code;
	@ApiModelProperty(value = "구군이름")
	private String gugun_name;

	public String getSido_code() {
		return sido_code;
	}

	public void setSido_code(String sido_code) {
		this.sido_code = sido_code;
	}

	public String getSido_name() {
		return sido_name;
	}

	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}

	public String getGugun_code() {
		return gugun_code;
	}

	public void setGugun_code(String gugun_code) {
		this.gugun_code = gugun_code;
	}

	public String getGugun_name() {
		return gugun_name;
	}

	public void setGugun_name(String gugun_name) {
		this.gugun_name = gugun_name;
	}

	@Override
	public String toString() {
		return "SidoGugunCodeDto [sido_code=" + sido_code + ", sido_name=" + sido_name + ", gugun_code=" + gugun_code
				+ ", gugun_name=" + gugun_name + "]";
	}

}
