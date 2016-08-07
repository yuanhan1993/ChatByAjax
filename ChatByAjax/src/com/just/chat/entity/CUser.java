package com.just.chat.entity;

import java.io.Serializable;

/**
 * 用户实体类 实现了Serializable接口
 * 
 * @author yh
 * 
 */
public class CUser implements Serializable {
	private Integer uid; // 用户id
	private String username;// 用户名
	private String password;// 密码
	private String nickname;// 昵称

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
