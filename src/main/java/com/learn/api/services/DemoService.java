package com.learn.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.api.dto.DemoDto;
import com.learn.api.entities.Demo;
import com.learn.api.repositories.IDemoRepository;

@Service
public class DemoService {
	@Autowired
	private IDemoRepository demoRepository;
	
	@Autowired
	private MapperService mapperService;
	
	public List<DemoDto> getAll() {
		List<Demo> demos = demoRepository.findAll();
		List<DemoDto> demoDtos = new ArrayList<DemoDto>();

		for (Demo t : demos) {
			demoDtos.add(mapperService.mapDemoToDto(t));
		}
		return demoDtos;
	}
}	
