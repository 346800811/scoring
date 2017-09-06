package com.scoring.service;

import java.util.List;

import com.scoring.model.VScore;

public interface VScoreService {
	List<VScore> list();

	/**
	 * 查询某类型的评分详情
	 */
	List<VScore> query(Integer type);

	/**
	 * 查询某类型的评分矩阵
	 * @param type
	 * @param projs 项目数
	 * @param marks 指标数
	 * @return
	 */
	double[][] getArr(Integer type, int projs, int marks);
}
