package cn.xdl.tol.vo;

import java.io.Serializable;

/**
 * 用户刷题知识点分析vo对象
 * @author Administrator
 *
 */
public class Practice_KResult implements Serializable {
	/**
	 * 知识点名称
	 */
	private String knowlege_name;
	/**
	 * 该知识点正确个数
	 */
	private Integer right;
	/**
	 * 该知识点总题目数
	 */
	private Integer total_question;
	/**
	 * 该知识点用户得分
	 */
	private Double user_score;
	/**
	 * 该知识点总分
	 */
	private Double total_socre;
	public String getKnowlege_name() {
		return knowlege_name;
	}
	public void setKnowlege_name(String knowlege_name) {
		this.knowlege_name = knowlege_name;
	}
	public Integer getRight() {
		return right;
	}
	public void setRight(Integer right) {
		this.right = right;
	}
	public Integer getTotal_question() {
		return total_question;
	}
	public void setTotal_question(Integer total_question) {
		this.total_question = total_question;
	}
	public Double getUser_score() {
		return user_score;
	}
	public void setUser_score(Double user_score) {
		this.user_score = user_score;
	}
	public Double getTotal_socre() {
		return total_socre;
	}
	public void setTotal_socre(Double total_socre) {
		this.total_socre = total_socre;
	}
	
}
