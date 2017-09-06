package com.scoring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoring.mapper.ProjTypeMapper;
import com.scoring.model.ProjType;
import com.scoring.service.ProjTypeService;

@Service
public class ProjTypeServiceImpl implements ProjTypeService {
	@Autowired
	ProjTypeMapper projTypeMapper;

	@Override
	public List<ProjType> list() {
		return projTypeMapper.list();
	}

}
