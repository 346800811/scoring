package com.scoring.mapper;

import java.util.List;

import com.scoring.model.Score;

public interface ScoreMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Score record);

	int insertSelective(Score record);

	Score selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Score record);

	int updateByPrimaryKey(Score record);

	List<Score> list();
}