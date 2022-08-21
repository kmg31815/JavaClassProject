package com.web.model;

public class User {

	/**
	 * UID (唯一值)
	 */
	private int userId;

	/**
	 * 使用者名稱 (帳號)
	 */
	private String userName;

	/**
	 * 密碼 (之後是否加密?)
	 */
	private String password;

	/**
	 * 空參數建構子 (雖然不寫也會自動產生，避免之後增加有參數建構子忘記加，先寫)
	 */
	public User() {

	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}

}
