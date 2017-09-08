package cn.xdl.tol.po;

import java.io.Serializable;

public class SelectWeekExamPo implements Serializable{
	private String search;
	private String subject;
	private String week;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	
}
