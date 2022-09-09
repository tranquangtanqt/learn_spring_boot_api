package com.learn.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "t_todo_detail")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class TodoDetail extends BaseEntity {

	private static final long serialVersionUID = -7258481487443491255L;

	@Column(name = "name")
	private String name;

	@Column(name = "sort_order")
	private Long sortOrder;

	@Column(name = "content", columnDefinition="text")
	private String content;

	@ManyToOne
	@JoinColumn(name = "todo_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("todoId")
	private Todo todo;
}