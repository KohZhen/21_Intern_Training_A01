package com.puzzle.mapper;

import java.util.List;
import java.util.Map;

import com.puzzle.entity.Menu;

public interface MenuMapper {

	public int create(Menu menu);

	public int delete(Integer id);

	public int update(Menu menu);

	public int updateSelective(Menu menu);

	public List<Menu> query(Menu menu);

	public Menu detail(Integer id);

	public int count(Menu menu);

}