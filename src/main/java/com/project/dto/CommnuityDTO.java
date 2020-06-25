package com.project.dto;

import java.sql.Date;

public class CommnuityDTO {
	
	private int num;
	private String category,title,writer;
	private Date date_num;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate_num() {
		return date_num;
	}
	public void setDate_num(Date date_num) {
		this.date_num = date_num;
	}

	
}
