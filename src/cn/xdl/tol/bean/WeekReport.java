package cn.xdl.tol.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 周测报告对象
 * @author CS
 *
 */
public class WeekReport implements Serializable{

	/**
	 * 周测学科名
	 */
	private String subject_name;
	/**
	 * 第几周的测试
	 */
	private String week_exam_name;
	/**
	 * 分数
	 */
	private double grade;
	/**
	 * 考试时间
	 */
	private Timestamp time;
	/**
	 * 题目数量
	 */
	private int questions;
	public WeekReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeekReport(String subject_name, String week_exam_name, double grade, Timestamp time, int questions) {
		super();
		this.subject_name = subject_name;
		this.week_exam_name = week_exam_name;
		this.grade = grade;
		this.time = time;
		this.questions = questions;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getWeek_exam_name() {
		return week_exam_name;
	}
	public void setWeek_exam_name(String week_exam_name) {
		this.week_exam_name = week_exam_name;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getQuestions() {
		return questions;
	}
	public void setQuestions(int questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "WeekReport [subject_name=" + subject_name + ", week_exam_name=" + week_exam_name + ", grade=" + grade
				+ ", time=" + time + ", questions=" + questions + "]";
	}
}
