package cn.xdl.tol.bean;

import java.io.Serializable;
/**
 * 试题表
 * @author zhangjing
 *
 */
public class QuestionAndSubjectAndKnowlege extends Question implements Serializable {
	/**
	 * 知识点
	 */
	private String knowlege_name;

	/**
	 * 学科名
	 */
	private String subject_name;

	public String getKnowlege_name() {
		return knowlege_name;
	}

	public void setKnowlege_name(String knowlege_name) {
		this.knowlege_name = knowlege_name;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}


	public QuestionAndSubjectAndKnowlege(String knowlege_name, String subject_name) {
		super();
		this.knowlege_name = knowlege_name;
		this.subject_name = subject_name;
	}

	public QuestionAndSubjectAndKnowlege() {
		super();
		// TODO Auto-generated constructor stub
	}


/*	@Override
	public String toString() {
		return "QuestionAndSubjectAndKnowlege [knowlege_name=" + knowlege_name + ", subject_name=" + subject_name
				+ ", Question_id=" + getQuestion_id() + ", Question_name=" + getQuestion_name()
				+ ", Score=" + getScore() + ", Easy_type=" + getEasy_type() + ", On_delete="
				+ getOn_delete() + "]";
	}*/

	public QuestionAndSubjectAndKnowlege(int question_id, String question_name, String option_A, String option_B,
			String option_C, String option_D, String answer, Double score, String easy_type, Integer knowlege_id,
			Integer stage_id, Integer weekly_type_id, Integer subject_id, int on_delete) {
		super(question_id, question_name, option_A, option_B, option_C, option_D, answer, score, easy_type, knowlege_id,
				stage_id, weekly_type_id, subject_id, on_delete);
	}

	@Override
	public String toString() {
		return "QuestionAndSubjectAndKnowlege [knowlege_name=" + knowlege_name + ", subject_name=" + subject_name
				+ ", Question_id=" + getQuestion_id() + ", Question_name=" + getQuestion_name()
				+ ", Option_A=" + getOption_A() + ", Option_B=" + getOption_B() + ", Option_C="
				+ getOption_C() + ", Option_D=" + getOption_D() + ", Answer=" + getAnswer() + ", Score="
				+ getScore() + ",Easy_type=" + getEasy_type() + ", Knowlege_id=" + getKnowlege_id()
				+ ", Stage_id=" + getStage_id() + ", Weekly_type_id=" + getWeekly_type_id()
				+ ", Subject_id=" + getSubject_id() + ", On_delete=" + getOn_delete() + "]";
	}


}
