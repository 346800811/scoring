package com.scoring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoring.mapper.VScoreMapper;
import com.scoring.model.VScore;
import com.scoring.service.VScoreService;

@Service
public class VScoreServiceImpl implements VScoreService {
	@Autowired
	VScoreMapper vScoreMapper;

	@Override
	public List<VScore> list() {
		return vScoreMapper.list();
	}

	@Override
	public List<VScore> query(Integer type) {
		return vScoreMapper.query(type);
	}

	@Override
	public double[][] getArr(Integer type, int projs, int marks) {
		List<VScore> list = this.query(type);
		double[][] res = new double[projs][marks];
		for (int i = 0; i < projs; i++) {
			for (int j = 0; j < marks; j++) {
				Float score = list.get(i * marks + j).getScore();
				res[i][j] = score == null ? -1 : score;
			}
		}
		return res;
	}

}
