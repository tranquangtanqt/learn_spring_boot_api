package com.learn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.constants.UrlDefine;
import com.learn.api.dto.ApiResponse;
import com.learn.api.dto.TodoDetailDto;
import com.learn.api.dto.TodoDto;
import com.learn.api.services.TodoDetailService;

import io.swagger.v3.oas.annotations.Parameter;

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
	
	/**
	 * Create 1 record table todo_detail
	 * @param todoDetailDto
	 * @return
	 */
	@PostMapping(UrlDefine.TODO_DETAIL_INFO)
	public ApiResponse<TodoDto> create(@RequestBody TodoDetailDto todoDetailDto) {
		TodoDto todoDto = new TodoDto();
		try {
			todoDto = todoDetailService.create(todoDetailDto);
			return new ApiResponse<TodoDto>(todoDto, HttpStatus.OK);
		} catch (Exception e) {
			/// log.error(e.getMessage(), e);
			return new ApiResponse<TodoDto>(todoDto, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	/**
	 * delete 1 record table todo_detail
	 * @param todoDetailDto
	 * @return
	 */
	@DeleteMapping(UrlDefine.TODO_DETAIL_BY_ID)
	public ApiResponse<TodoDto> delete(@Parameter(description = "ID") @PathVariable(name = "id") final Long id) {
		TodoDto todoDto = new TodoDto();
		try {
			todoDto = todoDetailService.delete(id);
			return new ApiResponse<TodoDto>(todoDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ApiResponse<TodoDto>(todoDto, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
