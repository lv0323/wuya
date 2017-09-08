package cn.xdl.tol.params;

import java.io.Serializable;

/**
 * 插入practice表的po对象
 * @author Zs
 *
 */
public class InsertPracticePO implements Serializable{
	/**
	 * 用户id
	 */
	private Integer user_id;
	/**
	 * 答题获得总分
	 */
	private Double score;
	/**
	 * 答题总数
	 */
	private Integer count;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
