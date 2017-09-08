package cn.xdl.tol.po;

import java.io.Serializable;

public class SelectNotInWeekExamQuestionPo implements Serializable{
	private int id;
	private String subject;
	private String week;
	private String knowlege;
	private String search;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getKnowlege() {
		return knowlege;
	}
	public void setKnowlege(String knowlege) {
		this.knowlege = knowlege;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	@Override
	public String toString() {
		return "SelectNotInWeekExamQuestionPo [id=" + id + ", subject=" + subject + ", week=" + week + ", knowlege="
				+ knowlege + ", search=" + search + "]";
	}
	public SelectNotInWeekExamQuestionPo(int id, String subject, String week, String knowlege, String search) {
		super();
		this.id = id;
		this.subject = subject;
		this.week = week;
		this.knowlege = knowlege;
		this.search = search;
	}
	public SelectNotInWeekExamQuestionPo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
