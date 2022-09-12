package com.learn.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "p_product")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity {
	private static final long serialVersionUID = 1157150498527651617L;

	/**
	 * Tên
	 */
	@Column(name = "name")
	private String name;

	/**
	 * Giá nhập
	 */
	@Column(name = "entry_price")
	private int entryPrice;

	/**
	 * Giá bán sỉ
	 */
	@Column(name = "wholesale_price")
	private int wholesalePrice;

	/**
	 * Giá bán lẻ
	 */
	@Column(name = "retail_price")
	private int retailPrice;

	/**
	 * Tồn kho
	 */
	@Column(name = "quantity_inventory")
	private int quantityInventory;

	/**
	 * Đã bán
	 */
	@Column(name = "quantity_sold")
	private int quantitySold;

	/**
	 * Đơn vị tính
	 */
	@Column(name = "unit")
	private String unit;

	/**
	 * Ghi chú
	 */
	@Column(name = "note")
	private String note;
}