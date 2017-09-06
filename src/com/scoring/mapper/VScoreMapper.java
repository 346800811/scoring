package com.scoring.mapper;

import java.util.List;

import com.scoring.model.VScore;

public interface VScoreMapper {
	List<VScore> list();

	/** 查询某类型的评分详情 */
	List<VScore> query(Integer type);
}