package com.learn.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.api.dto.TodoDetailDto;
import com.learn.api.entities.TodoDetail;
import com.learn.api.repositories.ITodoDetailRepository;

@Service
public class TodoDetailService {

	@Autowired
	private ITodoDetailRepository todoDetailRepository;

	@Autowired
	private MapperService mapperService;

	public List<TodoDetailDto> getAll() {
		List<TodoDetail> todoDetails = todoDetailRepository.findByOrderBySortOrderAsc();
		List<TodoDetailDto> todoDetailDtos = new ArrayList<TodoDetailDto>();
		for (TodoDetail detail : todoDetails) {
			todoDetailDtos.add(mapperService.mapTodoDetailToDto(detail));
		}
		return todoDetailDtos;
	}

}
