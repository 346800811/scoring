package com.scoring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoring.mapper.ProjMapper;
import com.scoring.service.ProjService;

@Service
public class ProjServiceImpl implements ProjService {
	@Autowired
	ProjMapper projMapper;

}
