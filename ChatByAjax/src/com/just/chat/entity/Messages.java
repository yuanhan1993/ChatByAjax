package com.just.chat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息实体类 实现了Serializable接口
 * 
 * @author yh
 * 
 */
public class Messages implements Serializable {
	private Integer mid; // 信息id
	private Integer fromUserId;// 发送方id
	private Integer toUserId; // 接收方id
	private String message; // 消息
	private Integer messageState;// 消息状态
	private Date messageTime; // 消息发送时间

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Integer fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Integer getToUserId() {
		return toUserId;
	}

	public void setToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMessageState() {
		return messageState;
	}

	public void setMessageState(Integer messageState) {
		this.messageState = messageState;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

}
