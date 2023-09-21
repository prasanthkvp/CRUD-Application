package com.jpa.example.project.model.response;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private int ResponseCode;
	private String ResponseMgs;
	private String data;
	private Object jData;

	public int getResponseCode() {
		return ResponseCode;
	}

	public void setResponseCode(int responseCode) {
		ResponseCode = responseCode;
	}

	public String getResponseMgs() {
		return ResponseMgs;
	}

	public void setResponseMgs(String responseMgs) {
		ResponseMgs = responseMgs;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Object getjData() {
		return jData;
	}

	public void setjData(Object jData) {
		this.jData = jData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
