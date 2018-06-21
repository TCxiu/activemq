package com.xiu.mq.model;

import java.io.Serializable;
import java.util.Date;

public class TransactionMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	//	主键Id
	private String id;
//	版本号
	private int version;
//	创建者
	private String creater;
//	修改者
	private String editor;
//	创建时间
	private Date createTime;
//	修改时间
	private Date editTime;
//	消息ID
	private String meaasgeId;
//	消息内容
	private Object messageBody;
//	消息数据类型 String或者Object
	private String messageDateType;
//	队列名称
	private String consumerQueue;
//	消息发送次数
	private Date messageSendTimes;
//	是否死亡
	private boolean areadlyDead;
//	消息发送状态
	private String status;
//	备注
	private String remark;
//	扩展字段一
	private String field1;
//	扩展字段二
	private String field2;
//	扩展字段三
	private String field3;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEditTime() {
		return editTime;
	}
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	public String getMeaasgeId() {
		return meaasgeId;
	}
	public void setMeaasgeId(String meaasgeId) {
		this.meaasgeId = meaasgeId;
	}
	public Object getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(Object messageBody) {
		this.messageBody = messageBody;
	}
	public String getMessageDateType() {
		return messageDateType;
	}
	public void setMessageDateType(String messageDateType) {
		this.messageDateType = messageDateType;
	}
	public String getConsumerQueue() {
		return consumerQueue;
	}
	public void setConsumerQueue(String consumerQueue) {
		this.consumerQueue = consumerQueue;
	}
	public Date getMessageSendTimes() {
		return messageSendTimes;
	}
	public void setMessageSendTimes(Date messageSendTimes) {
		this.messageSendTimes = messageSendTimes;
	}
	public boolean isAreadlyDead() {
		return areadlyDead;
	}
	public void setAreadlyDead(boolean areadlyDead) {
		this.areadlyDead = areadlyDead;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	@Override
	public String toString() {
		return "事物消息记录 主键:" + id + ", 版本:V" + version + ", 创建者:" + creater + ", 修改者:" + editor
				+ ", 创建时间:" + createTime + ", 修改时间:" + editTime + ", 消息主键:" + meaasgeId
				+ ", 消息内容:" + messageBody + ", 消息类型:" + messageDateType + ", 队列名称:"
				+ consumerQueue + ", 消息发送时间:" + messageSendTimes + ", 是否存活:" + areadlyDead
				+ ", 消息发送状态:" + status + ",备注:" + remark + ", 扩展字段一:" + field1 + ", 扩展字段二:" + field2
				+ ", 扩展字段三:" + field3;
	}
	
}
