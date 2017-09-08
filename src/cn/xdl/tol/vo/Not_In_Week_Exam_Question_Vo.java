package cn.xdl.tol.vo;

import java.io.Serializable;

public class Not_In_Week_Exam_Question_Vo implements Serializable{
	private int qid;
	private String easy;
	private String name;
	private String subject;
	private String stage;
	private String knowlege;
	private double score;
	public int getQid() {
		return qid;
	}
	public void setQid(int id) {
		this.qid = id;
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
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
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
	public String toString() {
		return "Not_In_Week_Exam_Question_Vo [id=" + qid + ", easy=" + easy + ", name=" + name + ", subject=" + subject
				+ ", stage=" + stage + ", knowlege=" + knowlege + ", score=" + score + "]";
	}
	public Not_In_Week_Exam_Question_Vo(int id, String easy, String name, String subject, String stage, String knowlege,
			double score) {
		super();
		this.qid = id;
		this.easy = easy;
		this.name = name;
		this.subject = subject;
		this.stage = stage;
		this.knowlege = knowlege;
		this.score = score;
	}
	public Not_In_Week_Exam_Question_Vo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
