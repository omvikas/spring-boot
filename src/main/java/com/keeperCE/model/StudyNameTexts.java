package com.keeperCE.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="study_name_texts")
public class StudyNameTexts {

	private int study_name_text_id;
	private int language_id;
	private String code;
	private String study_name;
	private String study_text;
	private int created_by;
	private Date date_created;
	private int modified_by;
	private Date date_modified;
	
	@Id
	@GeneratedValue
	@Column(name="study_name_text_id")
	public int getStudy_name_text_id() {
		return study_name_text_id;
	}
	public void setStudy_name_text_id(int study_name_text_id) {
		this.study_name_text_id = study_name_text_id;
	}
	
	@Column(name="language_id")
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="study_name")
	public String getStudy_name() {
		return study_name;
	}
	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}
	
	@Column(name="study_text")
	public String getStudy_text() {
		return study_text;
	}
	public void setStudy_text(String study_text) {
		this.study_text = study_text;
	}
	
	@Column(name="created_by")
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	
	@Column(name="date_created")
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	@Column(name="modified_by")
	public int getModified_by() {
		return modified_by;
	}
	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}
	
	@Column(name="date_modified")
	public Date getDate_modified() {
		return date_modified;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
		
}
