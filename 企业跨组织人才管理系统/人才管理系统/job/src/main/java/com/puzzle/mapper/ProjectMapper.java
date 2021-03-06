package com.puzzle.mapper;

import java.util.List;
import java.util.Map;

import com.puzzle.entity.Project;

public interface ProjectMapper {

	public int create(Project project);

	public int delete(Integer id);

	public int update(Project project);

	public int updateSelective(Project project);

	public List<Project> query(Project project);

	public Project detail(Integer id);

	public int count(Project project);

}