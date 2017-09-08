package cn.xdl.tol.vo;
import java.util.List;
import cn.xdl.tol.bean.Knowlege;
import cn.xdl.tol.bean.Stage;
/**
 * 供用户刷题选择的展示信息
 * @author Zs
 *
 */
public class Practice_Paper_Choose_VO {
	/**
	 * 学科编号
	 */
	private int subject_id;
	/**
	 * 学科名字
	 */
	private String subject_name;
	/**
	 * 阶段集合
	 */
	private List<Stage> stage_list;
	/**
	 * 知识点集合
	 */
	private List<List<Knowlege>> knowlege_list;
	/**
	 * 难度集合
	 */
	private List<String> easy_type;
	
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
	public List<Stage> getStage_list() {
		return stage_list;
	}
	public void setStage_list(List<Stage> stage_list) {
		this.stage_list = stage_list;
	}
	public List<List<Knowlege>> getKnowlege_list() {
		return knowlege_list;
	}
	public void setKnowlege_list(List<List<Knowlege>> knowlege_list) {
		this.knowlege_list = knowlege_list;
	}
	public List<String> getEasy_type() {
		return easy_type;
	}
	public void setEasy_type(List<String> easy_type) {
		this.easy_type = easy_type;
	}
	
}
