package cn.xdl.tol.bean;


import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 用户刷题信息表
 * @author sunyu
 *
 */
public class Practice implements Serializable{
	/**
	 * 用户刷题信息表
	 */
	private int practice_id;
	/**
	 * 用户编号
	 */
	private Integer user_id;
	/**
	 * 刷题时间
	 */
	private Timestamp time;
	/**
	 * 刷题数量
	 */
	private Integer count;
	/**
	 * 刷题成绩
	 */
	private Double score;
	/**
	 * 知识点
	 */
	private String knowlege_id;
	
	
	public Practice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPractice_id() {
		return practice_id;
	}
	public void setPractice_id(int practice_id) {
		this.practice_id = practice_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String  getknowlege_id() {
		return knowlege_id;
	}
	public void setknowlege_id(String  knowlege_id) {
		this.knowlege_id = knowlege_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + practice_id;
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
		Practice other = (Practice) obj;
		if (practice_id != other.practice_id)
			return false;
		return true;
	}
	/**
	 * 
	 * @param practice_id 用户刷题信息表 主键
	 * @param user_id 用户编号
	 * @param time 刷题时间
	 * @param count 刷题数量
	 * @param score 刷题成绩
	 * @param knowlege_id 知识点
	 */
	public Practice(int practice_id, Integer user_id, Timestamp time, Integer count, Double score, String  knowlege_id) {
		super();
		this.practice_id = practice_id;
		this.user_id = user_id;
		this.time = time;
		this.count = count;
		this.score = score;
		this.knowlege_id = knowlege_id;
	}
	@Override
	public String toString() {
		return "Practice [practice_id=" + practice_id + ", user_id=" + user_id + ", time=" + time + ", count=" + count
				+ ", score=" + score + ", knowlege_id=" + knowlege_id + "]";
	}
}
