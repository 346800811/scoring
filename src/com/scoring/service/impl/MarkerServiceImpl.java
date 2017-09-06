package com.scoring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoring.mapper.MarkerMapper;
import com.scoring.service.MarkerService;

@Service
public class MarkerServiceImpl implements MarkerService {
	@Autowired
	MarkerMapper markerMapper;

}
