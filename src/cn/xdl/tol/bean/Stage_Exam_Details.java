package cn.xdl.tol.bean;

import java.io.Serializable;
/**
 * 阶段测试卷试题表
 * @author sunyu
 *
 */
public class Stage_Exam_Details implements Serializable {
	/**
	 * 阶段测试卷试题表编号
	 */
	private int stage_exam_details_id;
	/**
	 * 阶段编号
	 */
	private Integer stage_exam_id;
	/**
	 * 试题编号
	 */
	private Integer question_id;
	
	
	public int getStage_exam_details_id() {
		return stage_exam_details_id;
	}
	public void setStage_exam_details_id(int stage_exam_details_id) {
		this.stage_exam_details_id = stage_exam_details_id;
	}
	public Integer getStage_exam_id() {
		return stage_exam_id;
	}
	public void setStage_exam_id(Integer stage_exam_id) {
		this.stage_exam_id = stage_exam_id;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stage_exam_details_id;
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
		Stage_Exam_Details other = (Stage_Exam_Details) obj;
		if (stage_exam_details_id != other.stage_exam_details_id)
			return false;
		return true;
	}
	public Stage_Exam_Details() {
		super();
	}
	/**
	 * 
	 * @param stage_exam_details_id  阶段测试卷试题表编号 主键
	 * @param stage_exam_id 阶段编号
	 * @param question_id 试题编号
	 */
	public Stage_Exam_Details(int stage_exam_details_id, Integer stage_exam_id, Integer question_id) {
		super();
		this.stage_exam_details_id = stage_exam_details_id;
		this.stage_exam_id = stage_exam_id;
		this.question_id = question_id;
	}
	@Override
	public String toString() {
		return "Stage_Exam_Details [stage_exam_details_id=" + stage_exam_details_id + ", stage_exam_id=" + stage_exam_id
				+ ", question_id=" + question_id + "]";
	}
}
