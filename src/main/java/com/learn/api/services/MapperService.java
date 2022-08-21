package com.learn.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.api.dto.DemoDto;
import com.learn.api.entities.Demo;

@Service
public class MapperService {

	@Autowired
	private ModelMapper mapper;
	
	public DemoDto mapDemoToDto(Demo demo) {
		return mapper.map(demo, DemoDto.class);
	}
}
