package com.learn.api.dto;

import java.io.Serializable;
import java.util.Collection;

import com.learn.api.entities.TodoDetail;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class TodoDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 2018326404157606961L;
	
	private String name;
	private Long sortOrder;
	private Collection<TodoDetail> todoDetail;
	
}
