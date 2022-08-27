package com.learn.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	/**
	 * Create 1 record table todo_detail
	 * 
	 * @param todoDetailDto
	 * @return
	 */
	@Transactional
	public TodoDetailDto create(TodoDetailDto todoDetailDto) {
		TodoDetail todoDetail = new TodoDetail();
		todoDetail.setName(todoDetailDto.getName());
		todoDetail.setSortOrder(Long.valueOf(10));
		todoDetail.setTodo(todoDetailDto.getTodo());
		todoDetailRepository.save(todoDetail);

		todoDetailDto.setId(todoDetail.getId());
//		todoDetailDto.setSortOrder(todoDetail.getId());
		return todoDetailDto;
	}

	/**
	 * Update 1 record table todo_detail
	 * 
	 * @param id
	 * @param todoDetailDto
	 */
	@Transactional
	public void update(long id, TodoDetailDto todoDetailDto) {
		TodoDetail todoDetail = todoDetailRepository.findById(id).get();
		todoDetail.setName(todoDetailDto.getName());
//		todoDetail.setSortOrder(todoDetailDto.getSortOrder());
		todoDetailRepository.save(todoDetail);
	}
}
