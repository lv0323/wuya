package cn.xdl.tol.bean;


import java.io.Serializable;
/**
 * 用户刷题答案表
 * @author 
 *
 */
public class Practice_Question implements Serializable{
	/**
	 * 用户刷题答案表编号
	 */
	private int practice_question_id;
	/**
	 * 刷题信息编号
	 */
	private Integer practice_id;
	/**
	 * 试题编号
	 */
	private Integer question_id;
	/**
	 * 用户答案
	 */
	private String user_answer;
	
	
	public int getPractice_question_id() {
		return practice_question_id;
	}
	public void setPractice_question_id(int practice_question_id) {
		this.practice_question_id = practice_question_id;
	}
	public Integer getPractice_id() {
		return practice_id;
	}
	public void setPractice_id(Integer practice_id) {
		this.practice_id = practice_id;
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
		result = prime * result + practice_id;
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
		Practice_Question other = (Practice_Question) obj;
		if (practice_id != other.practice_id)
			return false;
		return true;
	}
	public Practice_Question() {
		super();
	}
	/**
	 * 
	 * @param practice_question_id 用户刷题答案表编号 主键
	 * @param practice_id 刷题信息编号
	 * @param question_id 试题编号
	 * @param user_answer 用户答案
	 */
	public Practice_Question(int practice_question_id,Integer practice_id, Integer question_id, String user_answer) {
		super();
		this.practice_question_id = practice_question_id;
		this.practice_id = practice_id;
		this.question_id = question_id;
		this.user_answer = user_answer;
	}
	@Override
	public String toString() {
		return "Practice_Question [practice_question_id=" + practice_question_id + ", practice_id=" + practice_id
				+ ", question_id=" + question_id + ", user_answer=" + user_answer + "]";
	}
}
