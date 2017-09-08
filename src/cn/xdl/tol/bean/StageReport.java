package cn.xdl.tol.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 阶段测试报告对象
 * @author CS
 *
 */
public class StageReport implements Serializable{

	/**
	 * 阶段测试学科名
	 */
	private String subject_name;
	/**
	 * 第几阶段的测试
	 */
	private String stage_exam_name;
	/**
	 * 分数
	 */
	private double grade;
	/**
	 * 答题时间
	 */
	private Timestamp time;
	/**
	 * 题目数量
	 */
	private int questions;
	public StageReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StageReport(String subject_name, String stage_exam_name, double grade, Timestamp time, int questions) {
		super();
		this.subject_name = subject_name;
		this.stage_exam_name = stage_exam_name;
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
	public String getStage_exam_name() {
		return stage_exam_name;
	}
	public void setStage_exam_name(String stage_exam_name) {
		this.stage_exam_name = stage_exam_name;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(grade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + questions;
		result = prime * result + ((stage_exam_name == null) ? 0 : stage_exam_name.hashCode());
		result = prime * result + ((subject_name == null) ? 0 : subject_name.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		StageReport other = (StageReport) obj;
		if (Double.doubleToLongBits(grade) != Double.doubleToLongBits(other.grade))
			return false;
		if (questions != other.questions)
			return false;
		if (stage_exam_name == null) {
			if (other.stage_exam_name != null)
				return false;
		} else if (!stage_exam_name.equals(other.stage_exam_name))
			return false;
		if (subject_name == null) {
			if (other.subject_name != null)
				return false;
		} else if (!subject_name.equals(other.subject_name))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StageReport [subject_name=" + subject_name + ", stage_exam_name=" + stage_exam_name + ", grade=" + grade
				+ ", time=" + time + ", questions=" + questions + "]";
	}
	
	
}
