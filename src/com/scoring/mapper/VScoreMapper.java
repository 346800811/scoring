package com.scoring.mapper;

import java.util.List;

import com.scoring.model.VScore;

public interface VScoreMapper {
	/**
	 * 查询某类型的评分详情
	 * @param type
	 * @return
	 */
	List<VScore> query(Integer type);
}