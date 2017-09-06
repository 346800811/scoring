package com.scoring.mapper;

import java.util.List;

import com.scoring.model.Marker;

public interface MarkerMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Marker record);

	int insertSelective(Marker record);

	Marker selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Marker record);

	int updateByPrimaryKey(Marker record);

	/**
	 * 查询某类型的所有评分指标
	 * 
	 * @param type
	 * @return
	 */
	List<Marker> query(Integer type);
}