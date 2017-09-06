package com.scoring.service;

import java.util.List;

import com.scoring.model.Proj;

public interface ProjService {
	List<Proj> list();

	/**
	 * 查询某类型的所有项目
	 */
	List<Proj> query(Integer type);
}
