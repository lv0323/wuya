package cn.xdl.tol.params;

import java.io.Serializable;

/**
 * 获取刷题试卷的参数对象
 * @author Zs
 *
 */
public class Practice_PaperPO implements Serializable {
	/**
	 * 学科编号
	 */
	private Integer subject_id;
	/**
	 * 阶段编号
	 */
	private Integer stage_id;
	/**
	 * 知识点编号数组
	 */
	private int[] knowlege_ids;
	
	/**
	 * 试题难度
	 */
	private String easy_type;

	public Integer getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

	public Integer getStage_id() {
		return stage_id;
	}

	public void setStage_id(Integer stage_id) {
		this.stage_id = stage_id;
	}

	public int[] getKnowlege_ids() {
		return knowlege_ids;
	}

	public void setKnowlege_ids(int[] knowlege_ids) {
		this.knowlege_ids = knowlege_ids;
	}

	public String getEasy_type() {
		return easy_type;
	}

	public void setEasy_type(String easy_type) {
		this.easy_type = easy_type;
	}
	
}
