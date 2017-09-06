package com.scoring.model;

/**
 * 项目类别
 * @author JianDe
 */
public class ProjType {
	private Integer type;
	private String name;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	@Override
	public String toString() {
		return "ProjType [type=" + type + ", name=" + name + "]";
	}

}