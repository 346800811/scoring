package com.scoring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoring.mapper.MarkerMapper;
import com.scoring.model.Marker;
import com.scoring.service.MarkerService;

@Service
public class MarkerServiceImpl implements MarkerService {
	@Autowired
	MarkerMapper markerMapper;


}
