package com.learn.api.dto;

import java.io.Serializable;

import com.learn.api.entities.Todo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TodoDetailDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 7488837681504224633L;
	private Long id;
	private String name;
	private Long sortOrder;
	private Todo todo;
}
