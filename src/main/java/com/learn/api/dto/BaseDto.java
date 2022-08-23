package com.learn.api.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseDto implements Serializable {
	private static final long serialVersionUID = -6054101644980541500L;

	private Date createdAt;

	private Date updatedAt;
}