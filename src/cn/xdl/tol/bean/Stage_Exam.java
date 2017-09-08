package cn.xdl.tol.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 阶段测试卷表
 * @author sunyu
 *
 */
public class Stage_Exam implements Serializable {
	/**
	 * 阶段测试卷表编号
	 */
	private int stage_exam_id;
	/**
	 * 阶段编号
	 */
	private Integer stage_id;
	/**
	 * 禁用
	 */
	private int  display;
	/**
	 * 删除状态
	 */
	private int  on_delete;
	/**
	 * 阶段测试卷表名
	 */
	private String stage_exam_name;
	/**
	 * 总分
	 */
	private double tatal_points;
	/**
	 * 时间
	 */
	private Timestamp time;
	

	
	public double getTatal_points() {
		return tatal_points;
	}
	public void setTatal_points(double tatal_points) {
		this.tatal_points = tatal_points;
	}
	public int getStage_exam_id() {
		return stage_exam_id;
	}
	public void setStage_exam_id(int stage_exam_id) {
		this.stage_exam_id = stage_exam_id;
	}
	public Integer getStage_id() {
		return stage_id;
	}
	public void setStage_id(Integer stage_id) {
		this.stage_id = stage_id;
	}
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public int getOn_delete() {
		return on_delete;
	}
	public void setOn_delete(int on_delete) {
		this.on_delete = on_delete;
	}
	public String getStage_exam_name() {
		return stage_exam_name;
	}
	public void setStage_exam_name(String stage_exam_name) {
		this.stage_exam_name = stage_exam_name;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	/**
	 * 
	 * @param stage_exam_id  阶段测试卷表编号   主键
	 * @param stage_id 阶段编号
	 * @param display 禁用
	 * @param on_delete 删除
	 * @param stage_exam_name  阶段测试卷表名
	 * @param time 时间
	 * @param tatal_points 总分
	 */
	public Stage_Exam(int stage_exam_id, Integer stage_id, int display, int on_delete, String stage_exam_name,
			double tatal_points, Timestamp time) {
		super();
		this.stage_exam_id = stage_exam_id;
		this.stage_id = stage_id;
		this.display = display;
		this.on_delete = on_delete;
		this.stage_exam_name = stage_exam_name;
		this.tatal_points = tatal_points;
		this.time = time;
	}
	
	
	
	
	
	
	

	
	@Override
	public String toString() {
		return "Stage_Exam [stage_exam_id=" + stage_exam_id + ", stage_id=" + stage_id + ", display=" + display
				+ ", on_delete=" + on_delete + ", stage_exam_name=" + stage_exam_name + ", tatal_points=" + tatal_points
				+ ", time=" + time + "]";
	}
	public Stage_Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stage_exam_id;
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
		Stage_Exam other = (Stage_Exam) obj;
		if (stage_exam_id != other.stage_exam_id)
			return false;
		return true;
	}
	
	
}
