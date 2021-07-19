package com.puzzle.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.puzzle.utils.Entity;
import java.util.Date;



public class Favor extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer companyId;
	/**
	 * 
	 */
	private Integer postId;
	/**
	 * 
	 */
	private Integer applicantId;
	/**
	 * 
	 */
	private Date favorDate;


	private Post post;

	private Company company;

	private Applicant applicant;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public Date getFavorDate() {
		return favorDate;
	}
	public void setFavorDate(Date favorDate) {
		this.favorDate = favorDate;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
}