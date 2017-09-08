package cn.xdl.tol.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Week_Exam_List_Vo implements Serializable{
	/**
	 * 试卷编号
	 */
	private int id;
	/**
	 * 试卷名
	 */
	private String name;
	/**
	 * 学科
	 */
	private String subject;
	/**
	 * 周
	 */
	private String week;
	/**
	 * 禁用
	 */
	private int display;
	/**
	 * 创建时间
	 */
	private Timestamp time;
	/**
	 * 总分
	 */
	private double tatal_points;
	public Week_Exam_List_Vo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Week_Exam_List_Vo(int id, String name, String subject, String week, int display, Timestamp time,
			double tatal_points) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.week = week;
		this.display = display;
		this.time = time;
		this.tatal_points = tatal_points;
	}
	@Override
	public String toString() {
		return "Week_Exam_List_Vo [id=" + id + ", name=" + name + ", subject=" + subject + ", week=" + week
				+ ", display=" + display + ", time=" + time + ", tatal_points=" + tatal_points + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public double getTatal_points() {
		return tatal_points;
	}
	public void setTatal_points(double tatal_points) {
		this.tatal_points = tatal_points;
	}
	
	
	
	
	
	

}
