package cn.xdl.tol.bean;

import java.io.Serializable;
/**
 * 周表
 * @author sunyu
 *
 */
public class Weekly_Type implements Serializable{
	/**
	 * 周编号
	 */
	private int weekly_type_id;
	/**
	 * 周名字
	 */
	private String weekly_type_name;
	/**
	 * 学科编号
	 */
	private Integer subject_id;
	
	
	public int getWeekly_type_id() {
		return weekly_type_id;
	}
	public void setWeekly_type_id(int weekly_type_id) {
		this.weekly_type_id = weekly_type_id;
	}
	public String getWeekly_type_name() {
		return weekly_type_name;
	}
	public void setWeekly_type_name(String weekly_type_name) {
		this.weekly_type_name = weekly_type_name;
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
		result = prime * result + weekly_type_id;
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
		Weekly_Type other = (Weekly_Type) obj;
		if (weekly_type_id != other.weekly_type_id)
			return false;
		return true;
	}
	public Weekly_Type() {
		super();
	}
	/**
	 * 
	 * @param weekly_type_id 周编号 主键
	 * @param weekly_type_name 周名字
	 * @param subject_id 学科编号
	 */ 
	public Weekly_Type(int weekly_type_id, String weekly_type_name, Integer subject_id) {
		super();
		this.weekly_type_id = weekly_type_id;
		this.weekly_type_name = weekly_type_name;
		this.subject_id = subject_id;
	}
	@Override
	public String toString() {
		return "Weekly_Type [weekly_type_id=" + weekly_type_id + ", weekly_type_name=" + weekly_type_name
				+ ", subject_id=" + subject_id + "]";
	}
}
