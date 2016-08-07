package com.just.chat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ��Ϣʵ���� ʵ����Serializable�ӿ�
 * 
 * @author yh
 * 
 */
public class Messages implements Serializable {
	private Integer mid; // ��Ϣid
	private Integer fromUserId;// ���ͷ�id
	private Integer toUserId; // ���շ�id
	private String message; // ��Ϣ
	private Integer messageState;// ��Ϣ״̬
	private Date messageTime; // ��Ϣ����ʱ��

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
