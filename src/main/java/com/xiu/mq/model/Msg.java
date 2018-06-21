package com.xiu.mq.model;

import java.io.Serializable;

public class Msg implements Serializable{
	private static final long serialVersionUID = 1L;
	private String msg;
	private boolean status;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "消息内容为:" + msg + ", status=" + status + "]";
	}
}
