package com.scoring.model;

/**
 * 用户信息
 * @author JianDe
 */
public class User {
	private Integer id;
	private String name;
	private Integer type;
	private String passwd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd == null ? null : passwd.trim();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", type=" + type + ", passwd=" + passwd + "]";
	}

}