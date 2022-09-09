package com.learn.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.constants.UrlDefine;
import com.learn.api.dto.ApiResponse;
import com.learn.api.dto.TodoDto;
import com.learn.api.services.TodoService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	/**
	 * Get Todo
	 * @return
	 */
	@GetMapping(UrlDefine.TODO_BY_ID)
	public ApiResponse<TodoDto> getById(@Parameter(description = "TODO") @PathVariable(name="id") final Long id) {
		TodoDto todoDto = new TodoDto();
		try {
			todoDto = todoService.getById(id);
		} catch (Exception e) {
			return new ApiResponse<TodoDto>(todoDto, HttpStatus.EXPECTATION_FAILED);
		}
		return new ApiResponse<TodoDto>(todoDto, HttpStatus.OK);
	}
	
//	/**
//	 * Create 1 record table todo
//	 * @param homeLinkDto
//	 * @return
//	 */
//	@PostMapping(UrlDefine.TODO_INFO_CREATE)
//	public ApiResponse<Map<String, String>> create(@RequestBody TodoDto todoDto) {
//		try {
//			todoDto = todoService.create(todoDto);
//			return new ApiResponse<Map<String, String>>(new HashMap<>(), HttpStatus.OK);
//		} catch (Exception e) {
//			/// log.error(e.getMessage(), e);
//			return new ApiResponse<Map<String, String>>(new HashMap<>(), HttpStatus.EXPECTATION_FAILED);
//		}
//	}
}
