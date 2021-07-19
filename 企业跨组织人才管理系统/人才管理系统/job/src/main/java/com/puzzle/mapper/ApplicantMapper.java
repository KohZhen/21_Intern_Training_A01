package com.puzzle.mapper;

import java.util.List;

import com.puzzle.entity.Applicant;

public interface ApplicantMapper {

	public int create(Applicant applicant);

	public int delete(Integer id);

	public int update(Applicant applicant);

	public int updateSelective(Applicant applicant);

	public List<Applicant> query(Applicant applicant);

	public Applicant detail(Integer id);

	public int count(Applicant applicant);

}