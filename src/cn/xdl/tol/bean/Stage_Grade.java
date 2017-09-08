package cn.xdl.tol.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 阶段测成绩表
 * @author sunyu
 *
 */
public class Stage_Grade implements Serializable{
	/**
	 * 阶段测成绩表编号
	 */
	private int stage_grade_id;
	/**
	 * 用户编号
	 */
	private Integer user_id;
	/**
	 * 阶段测试卷编号
	 */
	private Integer stage_exam_id;
	/**
	 * 成绩
	 */
	private Double grade;
	/**
	 * 学科编号
	 */
	private Integer subject_id;
	/**
	 * 答题时间
	 */
	private Timestamp time;
	public int getStage_grade_id() {
		return stage_grade_id;
	}
	public void setStage_grade_id(int stage_grade_id) {
		this.stage_grade_id = stage_grade_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getStage_exam_id() {
		return stage_exam_id;
	}
	public void setStage_exam_id(Integer stage_exam_id) {
		this.stage_exam_id = stage_exam_id;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Integer getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Stage_Grade() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stage_grade_id;
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
		Stage_Grade other = (Stage_Grade) obj;
		if (stage_grade_id != other.stage_grade_id)
			return false;
		return true;
	}
	public Stage_Grade(int stage_grade_id, Integer user_id, Integer stage_exam_id, Double grade, Integer subject_id,
			Timestamp time) {
		super();
		this.stage_grade_id = stage_grade_id;
		this.user_id = user_id;
		this.stage_exam_id = stage_exam_id;
		this.grade = grade;
		this.subject_id = subject_id;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Stage_Grade [stage_grade_id=" + stage_grade_id + ", user_id=" + user_id + ", stage_exam_id="
				+ stage_exam_id + ", grade=" + grade + ", subject_id=" + subject_id + ", time=" + time + "]";
	}
	
	
	
	
}
