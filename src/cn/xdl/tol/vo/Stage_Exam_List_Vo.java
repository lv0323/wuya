package cn.xdl.tol.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Stage_Exam_List_Vo implements Serializable{
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
	 * 阶段
	 */
	private String stage;
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
	public Stage_Exam_List_Vo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stage_Exam_List_Vo(int id, String name, String subject, String stage, int display, Timestamp time,
			double tatal_points) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.stage = stage;
		this.display = display;
		this.time = time;
		this.tatal_points = tatal_points;
	}
	@Override
	public String toString() {
		return "Stage_Exam_List_Vo [id=" + id + ", name=" + name + ", subject=" + subject + ", stage=" + stage
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
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stage_Exam_List_Vo other = (Stage_Exam_List_Vo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
