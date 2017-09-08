package cn.xdl.tol.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 周测成绩表
 * @author sunyu
 *
 */
public class Week_Grade implements Serializable {
	/**
	 * 周测成绩表编号
	 */
	private int week_grade_id;
	/**
	 * 用户编号
	 */
	private Integer user_id;
	/**
	 * 周测试卷编号
	 */
	private Integer week_exam_id;
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
	
	public int getWeek_grade_id() {
		return week_grade_id;
	}
	public void setWeek_grade_id(int week_grade_id) {
		this.week_grade_id = week_grade_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getWeek_exam_id() {
		return week_exam_id;
	}
	public void setWeek_exam_id(Integer week_exam_id) {
		this.week_exam_id = week_exam_id;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + week_grade_id;
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
		Week_Grade other = (Week_Grade) obj;
		if (week_grade_id != other.week_grade_id)
			return false;
		return true;
	}
	public Week_Grade() {
		super();
	}
	/**
	 * 
	 * @param week_grade_id 周测成绩表编号 主键
	 * @param user_id 用户编号
	 * @param week_exam_id 周测试卷编号
	 * @param grade 成绩
	 * @param subject_id 学科编号
	 * @param time 答题时间
	 */
	public Week_Grade(int week_grade_id, Integer user_id, Integer week_exam_id, Double grade, Integer subject_id, Timestamp time) {
		super();
		this.week_grade_id = week_grade_id;
		this.user_id = user_id;
		this.week_exam_id = week_exam_id;
		this.grade = grade;
		this.subject_id = subject_id;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Week_Grade [week_grade_id=" + week_grade_id + ", user_id=" + user_id + ", week_exam_id=" + week_exam_id
				+ ", grade=" + grade + ", subject_id=" + subject_id + ", time=" + time + "]";
	}
	
	
}
