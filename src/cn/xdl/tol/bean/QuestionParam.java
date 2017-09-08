package cn.xdl.tol.bean;
/**
 * 
 * @author zhangjing
 *
 */
public class QuestionParam {
	 private int subject_id;
	 private int knowlege_id;
	 private String question_name;
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getKnowlege_id() {
		return knowlege_id;
	}
	public void setKnowlege_id(int knowlege_id) {
		this.knowlege_id = knowlege_id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	@Override
	public String toString() {
		return "QuestionParam [subject_id=" + subject_id + ", knowlege_id=" + knowlege_id + ", question_name="
				+ question_name + "]";
	}
	public QuestionParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionParam(int subject_id, int knowlege_id, String question_name) {
		super();
		this.subject_id = subject_id;
		this.knowlege_id = knowlege_id;
		this.question_name = question_name;
	}
	 
}
