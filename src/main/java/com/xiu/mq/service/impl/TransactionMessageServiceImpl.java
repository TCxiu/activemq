package com.xiu.mq.service.impl;

import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.xiu.mq.dto.TransactionMessageDto;
import com.xiu.mq.model.ResponModel;
import com.xiu.mq.model.TransactionMessage;
import com.xiu.mq.service.TransactionMessageService;
import com.xiu.mq.utils.CustomDozerUtils;

@Service
public class TransactionMessageServiceImpl implements TransactionMessageService{
	@Autowired
	StringRedisTemplate redisTemplate;
	
	
	public ResponModel prepare() {
		
		return null;
	}
	
	public ResponModel save(String key,TransactionMessage transactionMessage) {
		int flag=1;
		try {
			redisTemplate.opsForHash().put(key,transactionMessage.getId(), JSON.toJSONString(transactionMessage));
		} catch (Exception e) {
			flag=-1;
			System.out.println("插入redis失败");
		}
		if (flag>0) {
			return new ResponModel(0, "success","插入成功");
		}
		else {
			return new ResponModel(-1, "success","插入失败");
		}
	}
	
	public ResponModel getList(String key) {
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		Set<Object> transactionMessageRecords = hash.keys(key);
		ArrayList<TransactionMessageDto> list = new ArrayList<TransactionMessageDto>();
		transactionMessageRecords.forEach((columKey)->{
			String respon = (String) hash.get(key, columKey);
			TransactionMessage transactionMessage = JSON.parseObject(respon, TransactionMessage.class);
			TransactionMessageDto transactionMessageDto = new TransactionMessageDto();
			CustomDozerUtils.copy(transactionMessage, transactionMessageDto);
			transactionMessageDto.setTableName(key);
			transactionMessageDto.setColumName((String) columKey);
			list.add(transactionMessageDto);
		});
		return new ResponModel(0, "success",list);
	}
	
	public ResponModel getRecordByColumKey(String key,String columKey) {
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		String object = (String) hash.get(key, columKey);
		TransactionMessage respon = JSON.parseObject(object, TransactionMessage.class);
		return new ResponModel(0, "success",respon);
	}
	
	public ResponModel delRecordByColumKey(String key,String columKey) {
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		Long delete = hash.delete(key, columKey);
		if (delete>0) {
			return new ResponModel(0, "success","删除成功");
		}
		else 
			return new ResponModel(-1, "error","删除失败");
	}

	public ResponModel update(String tableName, String columKey,TransactionMessage transactionMessage) {
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		String object = (String) hash.get(tableName,columKey);
		TransactionMessage target = JSON.parseObject(object, TransactionMessage.class);
		CustomDozerUtils.copy(transactionMessage,target);
		int flag=1;
		try {
			hash.put(tableName,columKey, JSON.toJSONString(target));
		} catch (Exception e) {
			flag=-1;
		}
		if (flag>0) {
			return new ResponModel(0, "success","更新成功");
		}
		else {
			return new ResponModel(-1, "success","更新失败");
		}
	}


	@Override
	public ResponModel saveMessageWaitingConfirm(String key, TransactionMessage transactionMessage) {
		// TODO Auto-generated method stub
		return save(key, transactionMessage);
	}
	
	@Override
	public void confirmAndSendMessage(String messageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveAndSendMessage(TransactionMessage transactionMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void directSendMessage(TransactionMessage transactionMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reSendMessage(TransactionMessage transactionMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reSendMessageByMessageId(String messageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMessageToAreadlyDead(String messageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransactionMessage getMessageByMessageId(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMessageByMessageId(String messageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reSendAllDeadMessageByQueueName(String queueName, int batchSize) {
		// TODO Auto-generated method stub
		
	}
}
