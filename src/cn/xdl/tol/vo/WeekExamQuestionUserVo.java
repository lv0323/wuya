package cn.xdl.tol.vo;

public class WeekExamQuestionUserVo {
	/**
	 * 试题表编号
	 */
	private int question_id;
	/**
	 * 题目
	 */
	private String question_name;
	/**
	 * A选项
	 */
	private String option_A;
	/**
	 * B选项
	 */
	private String option_B;
	/**
	 * C选项
	 */
	private String option_C;
	/**
	 * D选项
	 */
	private String option_D;
	/**
	 * 答案
	 */
	private String answer;
	/**
	 * 分数
	 */
	private Double score;
	/**
	 * 难度
	 */
	private String easy_type;
	/**
	 * 知识点编号
	 */
	private Integer knowlege_id;
	/**
	 * 阶段编号
	 */
	private Integer stage_id;
	/**
	 * 周编号
	 */
	private Integer weekly_type_id;
	/**
	 * 学科编号
	 */
	private Integer subject_id;
	/**
	 * 删除
	 */
	private int on_delete;
	
	private String user_answer;

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_name() {
		return question_name;
	}

	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}

	public String getOption_A() {
		return option_A;
	}

	public void setOption_A(String option_A) {
		this.option_A = option_A;
	}

	public String getOption_B() {
		return option_B;
	}

	public void setOption_B(String option_B) {
		this.option_B = option_B;
	}

	public String getOption_C() {
		return option_C;
	}

	public void setOption_C(String option_C) {
		this.option_C = option_C;
	}

	public String getOption_D() {
		return option_D;
	}

	public void setOption_D(String option_D) {
		this.option_D = option_D;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getEasy_type() {
		return easy_type;
	}

	public void setEasy_type(String easy_type) {
		this.easy_type = easy_type;
	}

	public Integer getKnowlege_id() {
		return knowlege_id;
	}

	public void setKnowlege_id(Integer knowlege_id) {
		this.knowlege_id = knowlege_id;
	}

	public Integer getStage_id() {
		return stage_id;
	}

	public void setStage_id(Integer stage_id) {
		this.stage_id = stage_id;
	}

	public Integer getWeekly_type_id() {
		return weekly_type_id;
	}

	public void setWeekly_type_id(Integer weekly_type_id) {
		this.weekly_type_id = weekly_type_id;
	}

	public Integer getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

	public int getOn_delete() {
		return on_delete;
	}

	public void setOn_delete(int on_delete) {
		this.on_delete = on_delete;
	}

	public String getUserAnswer() {
		return user_answer;
	}

	public void setUserAnswer(String userAnswer) {
		this.user_answer = userAnswer;
	}
}
