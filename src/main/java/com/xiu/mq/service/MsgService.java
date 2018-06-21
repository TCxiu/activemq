package com.xiu.mq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiu.mq.jms.MsgProducer;
import com.xiu.mq.model.Msg;
import com.xiu.mq.model.ResponModel;

@Service
public class MsgService {
	@Autowired
	MsgProducer msgProducer;
	
	public ResponModel sendMsg(Msg msg) {
		msgProducer.sendPTPMessage("send-test", msg);
		return new ResponModel(1,"ok",msg);
	}
}
