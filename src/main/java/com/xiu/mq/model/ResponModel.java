package com.xiu.mq.model;

import java.io.Serializable;

public class ResponModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	private Object data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponModel(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public ResponModel() {
		this.code=1;
		this.msg="success";
		this.data="ok";
	}
}
