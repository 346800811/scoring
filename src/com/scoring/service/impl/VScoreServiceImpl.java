package com.scoring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoring.mapper.MarkerMapper;
import com.scoring.mapper.ProjMapper;
import com.scoring.mapper.VScoreMapper;
import com.scoring.model.Marker;
import com.scoring.model.Proj;
import com.scoring.model.VScore;
import com.scoring.service.VScoreService;

@Service
public class VScoreServiceImpl implements VScoreService {
	@Autowired
	VScoreMapper vScoreMapper;
	@Autowired
	ProjMapper projMapper;
	@Autowired
	MarkerMapper markerMapper;

	@Override
	public List<VScore> query(Integer type) {
		return vScoreMapper.query(type);
	}

	@Override
	public double[][] getArr(Integer type) {
		List<Marker> marks = markerMapper.query(type);
		List<Proj> projs = projMapper.query(type);
		List<VScore> list = this.query(type);
		double[][] res = new double[projs.size()][marks.size()];
		for (int i = 0; i < projs.size(); i++) {
			for (int j = 0; j < marks.size(); j++) {
				Float score = list.get(i * marks.size() + j).getScore();
				res[i][j] = score == null ? -1 : score;
			}
		}
		return res;
	}

}
