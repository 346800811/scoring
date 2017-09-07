package com.scoring.mapper;

import java.util.List;

import com.scoring.model.ProjType;

public interface ProjTypeMapper {
	int deleteByPrimaryKey(Integer type);

	int insert(ProjType record);

	ProjType selectByPrimaryKey(Integer type);

	int updateByPrimaryKey(ProjType record);

	List<ProjType> list();
}