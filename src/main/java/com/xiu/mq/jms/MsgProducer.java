package com.xiu.mq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgProducer{
    
    @Autowired
    @Qualifier("jmsMessagingTemplate")
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    JmsQueue jmsQueue;
	
    public void sendPTPMessage(String queueName,Object message) {
    	jmsQueue.setQueue(queueName);
    	jmsMessagingTemplate.convertAndSend(jmsQueue.getQueue(), message);
    }
    
    public void sendPubSubMessage(String topicName,Object message) {
    	jmsQueue.setTopic(topicName);
    	jmsMessagingTemplate.convertAndSend(jmsQueue.getTopic(), message);
    }
}