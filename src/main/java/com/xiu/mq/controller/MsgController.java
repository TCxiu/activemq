package com.xiu.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xiu.mq.model.Msg;
import com.xiu.mq.model.ResponModel;
import com.xiu.mq.service.MsgService;

@Controller
@RequestMapping("/msg")
public class MsgController {
	@Autowired
	MsgService msgService;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public ResponModel sendMsg(@RequestBody Msg msg) {
		ResponModel sendMsg = msgService.sendMsg(msg);
		return sendMsg;
	}
}
