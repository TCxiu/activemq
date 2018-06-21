package com.xiu.mq.listener;

import java.util.ArrayList;
import java.util.Set;
import javax.jms.JMSException;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.xiu.mq.dto.TransactionMessageDto;
import com.xiu.mq.model.Msg;
import com.xiu.mq.model.TransactionMessage;
import com.xiu.mq.service.TransactionMessageService;
import com.xiu.mq.utils.CustomDozerUtils;

@Component
public class MsgConsumer {
	@Autowired
	StringRedisTemplate redisTemplate;
	@Autowired
	TransactionMessageService transactionMessageService;
	@JmsListener(destination = "send-test",containerFactory = "jmsListenerContainerQueue")
	public void receiveQueue(ActiveMQObjectMessage receivedMsg) {
		Msg msg=null;
		try {
			msg = (Msg) receivedMsg.getObject();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		if (!msg.isStatus()) {
			System.out.println(msg.isStatus());
			HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
			Set<Object> transactionMessageRecords = hash.keys("transactionMessageRecord");
			ArrayList<TransactionMessageDto> list = new ArrayList<TransactionMessageDto>();
			transactionMessageRecords.forEach((columKey)->{
				String respon = (String) hash.get("transactionMessageRecord", columKey);
				TransactionMessage transactionMessage = JSON.parseObject(respon, TransactionMessage.class);
				TransactionMessageDto transactionMessageDto = new TransactionMessageDto();
				CustomDozerUtils.copy(transactionMessage, transactionMessageDto);
				transactionMessageDto.setTableName("transactionMessageRecord");
				transactionMessageDto.setColumName((String) columKey);
				list.add(transactionMessageDto);
			});
			System.out.println(JSON.toJSONString(list));
		}
	}
}
