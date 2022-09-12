package com.learn.api.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductDto extends BaseDto implements Serializable{
	private static final long serialVersionUID = -1583861074557304280L;
	
	private String name;
	private int entryPrice;
	private int wholesalePrice;
	private int retailPrice;
	private int quantityInventory;
	private int quantitySold;
	private String unit;
	private String notes;
}
