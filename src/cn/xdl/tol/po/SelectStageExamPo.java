package cn.xdl.tol.po;

import java.io.Serializable;

public class SelectStageExamPo implements Serializable{
	private String search;
	private String subject;
	private String stage;
	public SelectStageExamPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SelectStageExamPo(String search, String subject, String stage) {
		super();
		this.search = search;
		this.subject = subject;
		this.stage = stage;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	@Override
	public String toString() {
		return "SelectStageExamPo [search=" + search + ", subject=" + subject + ", stage=" + stage + "]";
	}
	
}
