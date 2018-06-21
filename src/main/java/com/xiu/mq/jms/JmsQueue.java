package com.xiu.mq.jms;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.stereotype.Component;

@Component
public class JmsQueue {
	private Queue queue;
	
	private Topic topic;
	
	public Queue getQueue() {
		return queue;
	}

	public void setQueue(String queueName) {
		this.queue = new ActiveMQQueue(queueName);
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(String topicName) {
		this.topic = new ActiveMQTopic(topicName);
	}
}
