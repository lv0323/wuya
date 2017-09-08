package cn.xdl.tol.vo;

import java.io.Serializable;
import java.util.List;

import cn.xdl.tol.bean.Knowlege;

/**
 * 刷题选项简单版
 * @author Zs
 *
 */
public class Practice_Paper_Easy_VO implements Serializable {
	/**
	 * 知识点集合
	 */
	private List<Knowlege> knowlege_list;
	/**
	 * 难度集合
	 */
	private List<String> easy_type;
	public List<Knowlege> getKnowlege_list() {
		return knowlege_list;
	}
	public void setKnowlege_list(List<Knowlege> knowlege_list) {
		this.knowlege_list = knowlege_list;
	}
	public List<String> getEasy_type() {
		return easy_type;
	}
	public void setEasy_type(List<String> easy_type) {
		this.easy_type = easy_type;
	}
}
