package com.scoring.mapper;

import java.util.List;

import com.scoring.model.Proj;

public interface ProjMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Proj record);

	int insertSelective(Proj record);

	Proj selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Proj record);

	int updateByPrimaryKey(Proj record);

	/**
	 * 查询某类型的所有项目
	 * 
	 * @param type
	 * @return
	 */
	List<Proj> query(Integer type);
}