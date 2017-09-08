package cn.xdl.tol.bean;

import java.io.Serializable;
/**
 * 阶段表
 * @author sunyu
 *
 */
public class Stage implements Serializable{
	/**
	 * 阶段编号
	 */
	private int stage_id;
	/**
	 * 阶段名称
	 */
	private String stage_name;
	/**
	 * 学科编号
	 */
	private Integer subject_id;
	
	
	public int getStage_id() {
		return stage_id;
	}
	public void setStage_id(int stage_id) {
		this.stage_id = stage_id;
	}
	public String getStage_name() {
		return stage_name;
	}
	public void setStage_name(String stage_name) {
		this.stage_name = stage_name;
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
		result = prime * result + stage_id;
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
		Stage other = (Stage) obj;
		if (stage_id != other.stage_id)
			return false;
		return true;
	}
	public Stage() {
		super();
	}
	/**
	 * 
	 * @param stage_id 阶段编号 主键
	 * @param stage_name 阶段名称
	 * @param subject_id 学科编号
	 */
	public Stage(int stage_id, String stage_name, Integer subject_id) {
		super();
		this.stage_id = stage_id;
		this.stage_name = stage_name;
		this.subject_id = subject_id;
	}
	@Override
	public String toString() {
		return "Stage [stage_id=" + stage_id + ", stage_name=" + stage_name + ", subject_id=" + subject_id + "]";
	}
}
