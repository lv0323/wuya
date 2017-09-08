package cn.xdl.tol.vo;

import java.io.Serializable;

public class Week_Exam_Question_List_vo implements Serializable {
	public int id;
	public String easy;
	public String name;
	public String subject;
	public String week;
	public String knowlege;
	public double score;
	public Week_Exam_Question_List_vo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Week_Exam_Question_List_vo(int id, String easy, String name, String subject, String week, String knowlege,
			double score) {
		super();
		this.id = id;
		this.easy = easy;
		this.name = name;
		this.subject = subject;
		this.week = week;
		this.knowlege = knowlege;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Week_Exam_Question_List_vo [id=" + id + ", easy=" + easy + ", name=" + name + ", subject=" + subject
				+ ", week=" + week + ", knowlege=" + knowlege + ", score=" + score + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEasy() {
		return easy;
	}
	public void setEasy(String easy) {
		this.easy = easy;
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
	public String getKnowlege() {
		return knowlege;
	}
	public void setKnowlege(String knowlege) {
		this.knowlege = knowlege;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
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
		Week_Exam_Question_List_vo other = (Week_Exam_Question_List_vo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
