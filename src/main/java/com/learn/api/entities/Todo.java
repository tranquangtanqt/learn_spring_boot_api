package com.learn.api.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "t_todo")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Todo extends BaseEntity{

	private static final long serialVersionUID = 3812284704887122697L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "content", columnDefinition="text")
	private String content;

	@Column(name = "sort_order")
	private Long sortOrder;
	
	@OneToMany(mappedBy = "todo")
	private Collection<TodoDetail> todoDetail;

}
