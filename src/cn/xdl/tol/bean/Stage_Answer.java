package cn.xdl.tol.bean;

import java.io.Serializable;
/**
 * 阶段测用户答案表
 * @author sunyu
 *
 */
public class Stage_Answer implements Serializable{
	/**
	 * 阶段测用户答案表编号
	 */
	private int stage_answer_id;
	/**
	 * 成绩编号
	 */
	private Integer stage_grade_id;
	/**
	 * 试题编号
	 */
	private Integer question_id;
	/**
	 * 用户答案
	 */
	private String user_answer;
	/**
	 * 是否正确
	 */
	private Integer is_right;
	public int getStage_answer_id() {
		return stage_answer_id;
	}
	public void setStage_answer_id(int stage_answer_id) {
		this.stage_answer_id = stage_answer_id;
	}
	public Integer getStage_grade_id() {
		return stage_grade_id;
	}
	public void setStage_grade_id(Integer stage_grade_id) {
		this.stage_grade_id = stage_grade_id;
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
	public Integer getIs_right() {
		return is_right;
	}
	public void setIs_right(Integer is_right) {
		this.is_right = is_right;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stage_answer_id;
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
		Stage_Answer other = (Stage_Answer) obj;
		if (stage_answer_id != other.stage_answer_id)
			return false;
		return true;
	}
	public Stage_Answer() {
		super();
	}
	/**
	 * 阶段试卷答案表
	 * @param stage_answer_id 阶段试卷答案编号
	 * @param stage_grade_id 阶段成绩编号
	 * @param question_id 问题编号
	 * @param user_answer 用户答案
	 * @param is_right 是否正确
	 */
	public Stage_Answer(int stage_answer_id, Integer stage_grade_id, Integer question_id, String user_answer,
			Integer is_right) {
		super();
		this.stage_answer_id = stage_answer_id;
		this.stage_grade_id = stage_grade_id;
		this.question_id = question_id;
		this.user_answer = user_answer;
		this.is_right = is_right;
	}
	@Override
	public String toString() {
		return "Stage_Answer [stage_answer_id=" + stage_answer_id + ", stage_grade_id=" + stage_grade_id
				+ ", question_id=" + question_id + ", user_answer=" + user_answer + ", is_right=" + is_right + "]";
	}
	
	
	
	
}
