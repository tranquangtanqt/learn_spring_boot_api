package com.learn.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.constants.UrlDefine;
import com.learn.api.dto.ApiResponse;
import com.learn.api.dto.TodoDto;
import com.learn.api.services.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping(UrlDefine.TODO_INFO)
	public ApiResponse<List<TodoDto>> getAll() {
		List<TodoDto> todoDtos = null;
		try {
			todoDtos = todoService.getAll();
		} catch (Exception e) {
			return new ApiResponse<List<TodoDto>>(todoDtos, HttpStatus.EXPECTATION_FAILED);
		}
		return new ApiResponse<List<TodoDto>>(todoDtos, HttpStatus.OK);
	}
	
	/**
	 * Create 1 record table todo
	 * @param homeLinkDto
	 * @return
	 */
	@PostMapping(UrlDefine.TODO_INFO_CREATE)
	public ApiResponse<Map<String, String>> create(@RequestBody TodoDto todoDto) {
		try {
			todoDto = todoService.create(todoDto);
			return new ApiResponse<Map<String, String>>(new HashMap<>(), HttpStatus.OK);
		} catch (Exception e) {
			/// log.error(e.getMessage(), e);
			return new ApiResponse<Map<String, String>>(new HashMap<>(), HttpStatus.EXPECTATION_FAILED);
		}
	}
}
