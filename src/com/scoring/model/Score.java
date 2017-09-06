package com.scoring.model;

public class Score {
	private Integer id;
	private Integer projId;
	private Integer markerId;
	private Integer userId;
	private Float score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public Integer getMarkerId() {
		return markerId;
	}

	public void setMarkerId(Integer markerId) {
		this.markerId = markerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", projId=" + projId + ", markerId=" + markerId + ", userId=" + userId + ", score=" + score + "]";
	}

}