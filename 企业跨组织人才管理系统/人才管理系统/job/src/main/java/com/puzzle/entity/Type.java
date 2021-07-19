package com.puzzle.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.puzzle.utils.Entity;
import java.util.Date;



public class Type extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@Length(max = 100)
	private String name;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}