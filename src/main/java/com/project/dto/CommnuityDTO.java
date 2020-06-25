package com.project.dto;

import java.sql.Date;

public class CommnuityDTO {
	
	private int notice_id;
	private String notice_title;
	private String notice_coments;
	private Date mod_date;
	
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_coments() {
		return notice_coments;
	}
	public void setNotice_coments(String notice_coments) {
		this.notice_coments = notice_coments;
	}
	public Date getMod_date() {
		return mod_date;
	}
	public void setMod_date(Date mod_date) {
		this.mod_date = mod_date;
	}
	
	

}
