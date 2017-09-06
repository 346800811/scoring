package com.scoring.model;

public class VScore {
	private Integer pid;
	private Integer mid;
	private Float score;
	private Integer type;
	private Integer userId;
	private String pname;
	private String mname;
	private String typename;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname == null ? null : pname.trim();
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname == null ? null : mname.trim();
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename == null ? null : typename.trim();
	}

	@Override
	public String toString() {
		return "VScore [pid=" + pid + ", mid=" + mid + ", score=" + score + ", type=" + type + ", userId=" + userId
				+ ", pname=" + pname + ", mname=" + mname + ", typename=" + typename + "]";
	}

}