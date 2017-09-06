package com.scoring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoring.mapper.ScoreMapper;
import com.scoring.model.Score;
import com.scoring.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	ScoreMapper scoreMapper;

	@Override
	public List<Score> list() {
		return scoreMapper.list();
	}

}
