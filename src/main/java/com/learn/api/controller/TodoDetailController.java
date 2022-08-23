package com.learn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.constants.UrlDefine;
import com.learn.api.dto.ApiResponse;
import com.learn.api.dto.TodoDetailDto;
import com.learn.api.services.TodoDetailService;

@RestController
public class TodoDetailController {
	
	@Autowired
	private TodoDetailService todoDetailService;
	
	@GetMapping(UrlDefine.TODO_DETAIL_INFO)
	public ApiResponse<List<TodoDetailDto>> getAll() {
		List<TodoDetailDto> todoDetailDtos = null;
		try {
			todoDetailDtos = todoDetailService.getAll();
		} catch (Exception e) {
			return new ApiResponse<List<TodoDetailDto>>(todoDetailDtos, HttpStatus.EXPECTATION_FAILED);
		}
		return new ApiResponse<List<TodoDetailDto>>(todoDetailDtos, HttpStatus.OK);
	}
}
