package com.scoring.mapper;

import java.util.List;

import com.scoring.model.ProjType;

public interface ProjTypeMapper {
	int deleteByPrimaryKey(Integer type);

	int insert(ProjType record);

	int insertSelective(ProjType record);

	ProjType selectByPrimaryKey(Integer type);

	int updateByPrimaryKeySelective(ProjType record);

	int updateByPrimaryKey(ProjType record);

	List<ProjType> list();
}