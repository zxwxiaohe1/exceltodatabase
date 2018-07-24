package com.sinux.ssm.entity;

public class User {
	private int uid;
	private int age;
	private String name;
	private String number;
	private String loginname;
	private String password;

	public User(int uid, int age, String name, String loginname,
			String password, String number) {
		super();
		this.uid = uid;
		this.age = age;
		this.name = name;
		this.number = number;
		this.loginname = loginname;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
