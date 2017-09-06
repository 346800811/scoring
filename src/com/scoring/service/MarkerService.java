package com.scoring.service;

import java.util.List;

import com.scoring.model.Marker;

public interface MarkerService {
	List<Marker> list();

	/**
	 * 查询某类型的所有评分指标
	 */
	List<Marker> query(Integer type);
}
