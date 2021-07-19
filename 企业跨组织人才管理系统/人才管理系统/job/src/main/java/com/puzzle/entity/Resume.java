package com.puzzle.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.puzzle.utils.Entity;
import java.util.Date;



public class Resume extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@Length(max = 100)
	private String name;
	/**
	 * 
	 */
	private String jobStatus;
	/**
	 * 
	 */
	@Length(max = 0)
	private String evaluate;
	/**
	 * 
	 */
	@Length(max = 0)
	private String skill;
	/**
	 * 
	 */
	private Integer applicantId;
	/**
	 * 0关闭|1开放
	 */
	private Integer status;

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
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer studentId) {
		this.applicantId = applicantId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}