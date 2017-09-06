package com.scoring.service;

import java.util.List;

import com.scoring.model.VScore;

public interface VScoreService {
	/**
	 * 查询某类型的评分详情
	 * @param type
	 * @return
	 */
	List<VScore> list(Integer type);

	/**
	 * 查询某类型的评分矩阵
	 * @param type
	 * @return
	 */
	double[][] getArr(Integer type);
}
