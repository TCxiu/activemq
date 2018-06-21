package com.xiu.mq.service;

import com.xiu.mq.model.ResponModel;
import com.xiu.mq.model.TransactionMessage;

public interface TransactionMessageService {
	/**
	 * 预存储消息. 
	 */
	public ResponModel saveMessageWaitingConfirm(String key,TransactionMessage transactionMessage);
	
	
	/**
	 * 确认并发送消息.
	 */
	public void confirmAndSendMessage(String messageId);

	
	/**
	 * 存储并发送消息.
	 */
	public int saveAndSendMessage(TransactionMessage transactionMessage);

	
	/**
	 * 直接发送消息.
	 */
	public void directSendMessage(TransactionMessage transactionMessage);
	
	
	/**
	 * 重发消息.
	 */
	public void reSendMessage(TransactionMessage transactionMessage);
	
	
	/**
	 * 根据messageId重发某条消息.
	 */
	public void reSendMessageByMessageId(String messageId);
	
	
	/**
	 * 将消息标记为死亡消息.
	 */
	public void setMessageToAreadlyDead(String messageId);


	/**
	 * 根据消息ID获取消息
	 */
	public TransactionMessage getMessageByMessageId(String messageId);

	/**
	 * 根据消息ID删除消息
	 */
	public void deleteMessageByMessageId(String messageId);
	
	
	/**
	 * 重发某个消息队列中的全部已死亡的消息.
	 */
	public void reSendAllDeadMessageByQueueName(String queueName, int batchSize);
}
