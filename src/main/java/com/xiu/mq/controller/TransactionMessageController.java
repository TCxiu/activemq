package com.xiu.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xiu.mq.model.ResponModel;
import com.xiu.mq.model.TransactionMessage;
import com.xiu.mq.service.impl.TransactionMessageServiceImpl;

@Controller
public class TransactionMessageController {
	@Autowired
	TransactionMessageServiceImpl transactionMessageService;
	
	@RequestMapping(value="/{tableName}",method=RequestMethod.GET)
	@ResponseBody
	public ResponModel recordList(@PathVariable String tableName) {
		ResponModel respon = transactionMessageService.getList(tableName);
		return respon;
	}
	
	@RequestMapping(value="/{tableName}/{columKey}",method=RequestMethod.GET)
	@ResponseBody
	public ResponModel getRecordByColumKey(@PathVariable String tableName,@PathVariable String columKey) {
		ResponModel respon = transactionMessageService.getRecordByColumKey(tableName, columKey);
		return respon;
	}
	
	@RequestMapping(value="/{tableName}/{columKey}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponModel delRecordByColumKey(@PathVariable String tableName,@PathVariable String columKey) {
		ResponModel respon = transactionMessageService.delRecordByColumKey(tableName, columKey);
		return respon;
	}
	
	@RequestMapping(value="/{tableName}",method=RequestMethod.POST)
	@ResponseBody
	public ResponModel addRecordByColumKey(@PathVariable String tableName,@RequestBody TransactionMessage transactionMessage) {
		ResponModel respon = transactionMessageService.save(tableName, transactionMessage);
		return respon;
	}
	
	@RequestMapping(value="/{tableName}/{columKey}",method=RequestMethod.PUT)
	@ResponseBody
	public ResponModel updateRecordByColumKey(@PathVariable String tableName,@PathVariable  String columKey,@RequestBody TransactionMessage transactionMessage) {
		ResponModel respon = transactionMessageService.update(tableName,columKey,transactionMessage);
		return respon;
	}
}
