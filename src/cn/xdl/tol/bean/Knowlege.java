package cn.xdl.tol.bean;


import java.io.Serializable;
/**
 * 知识点表
 * @author 
 *
 */
public class Knowlege implements Serializable{
	/**
	 * 知识点编号
	 */
	private int knowlege_id;
	/**
	 * 知识点名称
	 */
	private String knowlege_name;
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
	
	
	public int getknowlege_id() {
		return knowlege_id;
	}
	public void setknowlege_id(int knowlege_id) {
		this.knowlege_id = knowlege_id;
	}
	public String getknowlege_name() {
		return knowlege_name;
	}
	public void setknowlege_name(String knowlege_name) {
		this.knowlege_name = knowlege_name;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + knowlege_id;
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
		Knowlege other = (Knowlege) obj;
		if (knowlege_id != other.knowlege_id)
			return false;
		return true;
	}
	public Knowlege() {
		super();
	}
	/**
	 * 
	 * @param knowlege_id  知识点编号 主键
	 * @param knowlege_name 知识点名称
	 * @param stage_id 阶段编号
	 * @param weekly_type_id 周编号
	 * @param subject_id 学科编号
	 */
	public Knowlege(int knowlege_id, String knowlege_name, Integer stage_id,Integer weekly_type_id,Integer subject_id) {
		super();
		this.knowlege_id = knowlege_id;
		this.knowlege_name = knowlege_name;
		this.stage_id = stage_id;
		this.weekly_type_id = weekly_type_id;
		this.subject_id = subject_id;
	}
	@Override
	public String toString() {
		return "Knowledge [knowlege_id=" + knowlege_id + ", knowlege_name=" + knowlege_name + ", stage_id="
				+ stage_id + ", weekly_type_id=" + weekly_type_id + ", subject_id=" + subject_id + "]";
	}
}
