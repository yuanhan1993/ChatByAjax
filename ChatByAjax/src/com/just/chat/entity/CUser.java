package com.just.chat.entity;

import java.io.Serializable;

/**
 * �û�ʵ���� ʵ����Serializable�ӿ�
 * 
 * @author yh
 * 
 */
public class CUser implements Serializable {
	private Integer uid; // �û�id
	private String username;// �û���
	private String password;// ����
	private String nickname;// �ǳ�

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
