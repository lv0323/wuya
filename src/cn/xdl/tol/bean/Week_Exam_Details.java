package cn.xdl.tol.bean;

import java.io.Serializable;
/**
 * 周测试卷试题表
 * @author sunyu
 *
 */
public class Week_Exam_Details implements Serializable{
	/**
	 * 周测试卷试题编号
	 */
	private int week_exam_details_id;
	/**
	 * 周测试卷表编号
	 */
	private Integer week_exam_id;
	/**
	 * 试题编号
	 */
	private Integer question_id;
	
	
	
	
	public int getWeek_exam_details_id() {
		return week_exam_details_id;
	}
	public void setWeek_exam_details_id(int week_exam_details_id) {
		this.week_exam_details_id = week_exam_details_id;
	}
	public Integer getWeek_exam_id() {
		return week_exam_id;
	}
	public void setWeek_exam_id(Integer week_exam_id) {
		this.week_exam_id = week_exam_id;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	public Week_Exam_Details() {
		super();
	}
	/**
	 * 
	 * @param week_exam_details_id  周测试卷试题编号
	 * @param week_exam_id 周测试卷表编号
	 * @param question_id 试题编号
	 */
	public Week_Exam_Details(int week_exam_details_id, Integer week_exam_id, Integer question_id) {
		super();
		this.week_exam_details_id = week_exam_details_id;
		this.week_exam_id = week_exam_id;
		this.question_id = question_id;
	}
	@Override
	public String toString() {
		return "Week_Exam_Details [week_exam_details_id=" + week_exam_details_id + ", week_exam_id=" + week_exam_id
				+ ", question_id=" + question_id + "]";
	}
}
