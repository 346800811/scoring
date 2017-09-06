package com.scoring.model;

/**
 * 项目信息
 * @author JianDe
 */
public class Proj {
	private Integer id;
	private String name;
	private Integer type;

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

	@Override
	public String toString() {
		return "Proj [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}