package com.productapp.model;

import lombok.Data;

@Data
public class CustomResponse {
private int code;
private String status;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
