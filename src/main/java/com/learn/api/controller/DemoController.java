package com.learn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.constants.UrlDefine;
import com.learn.api.dto.ApiResponse;
import com.learn.api.dto.DemoDto;
import com.learn.api.services.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping(UrlDefine.DEMO_INFO)
	public ApiResponse<List<DemoDto>> getAll() {
		List<DemoDto> demoDtos = null;
		try {
			demoDtos = demoService.getAll();
		} catch (Exception e) {
			return new ApiResponse<List<DemoDto>>(demoDtos, HttpStatus.EXPECTATION_FAILED);
		}
		return new ApiResponse<List<DemoDto>>(demoDtos, HttpStatus.OK);
	}
}
