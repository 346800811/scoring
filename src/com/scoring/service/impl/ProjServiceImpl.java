package com.scoring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoring.mapper.ProjMapper;
import com.scoring.model.Proj;
import com.scoring.service.ProjService;

@Service
public class ProjServiceImpl implements ProjService {
	@Autowired
	ProjMapper projMapper;

	@Override
	public List<Proj> list() {
		return projMapper.list();
	}

	@Override
	public List<Proj> query(Integer type) {
		return projMapper.query(type);
	}

}
