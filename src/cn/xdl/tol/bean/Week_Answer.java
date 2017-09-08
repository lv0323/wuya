package cn.xdl.tol.bean;

import java.io.Serializable;
/**
 * 周测用户答案表
 * @author sunyu
 *
 */
public class Week_Answer implements Serializable{
	/**
	 * 编号
	 */
	private int week_answer_id;
	/**
	 * 成绩编号
	 */
	private Integer week_grade_id;
	/**
	 * 试题编号
	 */
	private Integer question_id;
	/**
	 * 用户答案
	 */
	private String user_answer;
	
	/**
	 * 
	 * 答案是否正确
	 */
	private int is_right;
	
	public int getIs_right() {
		return is_right;
	}
	public void setIs_right(int is_right) {
		this.is_right = is_right;
	}
	public int getWeek_answer_id() {
		return week_answer_id;
	}
	public void setWeek_answer_id(int week_answer_id) {
		this.week_answer_id = week_answer_id;
	}
	public Integer getWeek_grade_id() {
		return week_grade_id;
	}
	public void setWeek_grade_id(Integer week_grade_id) {
		this.week_grade_id = week_grade_id;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	public String getUser_answer() {
		return user_answer;
	}
	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + week_answer_id;
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
		Week_Answer other = (Week_Answer) obj;
		if (week_answer_id != other.week_answer_id)
			return false;
		return true;
	}
	public Week_Answer() {
		super();
	}
	/**
	 * 
	 * @param week_answer_id 编号 主键
	 * @param week_grade_id 成绩编号
	 * @param question_id 试题编号
	 * @param user_answer 用户答案
	 */
	public Week_Answer(int week_answer_id, Integer week_grade_id, Integer question_id, String user_answer) {
		super();
		this.week_answer_id = week_answer_id;
		this.week_grade_id = week_grade_id;
		this.question_id = question_id;
		this.user_answer = user_answer;
	}
	@Override
	public String toString() {
		return "Week_answer [week_answer_id=" + week_answer_id + ", week_grade_id=" + week_grade_id + ", question_id="
				+ question_id + ", user_answer=" + user_answer + "]";
	}
}
