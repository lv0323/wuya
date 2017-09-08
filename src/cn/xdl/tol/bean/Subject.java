package cn.xdl.tol.bean;

import java.io.Serializable;
/**
 * 学科类
 * @author sunyu
 *
 */
public class Subject implements Serializable{
	/**
	 * 学科编号
	 */
	private int subject_id;
	/**
	 * 学科名字
	 */
	private String subject_name;
	
	
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subject_id;
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
		Subject other = (Subject) obj;
		if (subject_id != other.subject_id)
			return false;
		return true;
	}
	public Subject() {
		super();
	}
	/**
	 * 
	 * @param subject_id 学科编号
	 * @param subject_name 学科名字
	 */
	public Subject(int subject_id, String subject_name) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subject_name;
	}
	@Override
	public String toString() {
		return "Subject [subject_id=" + subject_id + ", subject_name=" + subject_name + "]";
	}
}
