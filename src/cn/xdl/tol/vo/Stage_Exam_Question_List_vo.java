package cn.xdl.tol.vo;

public class Stage_Exam_Question_List_vo {
	public int id;
	public String easy;
	public String name;
	public String subject;
	public String stage;
	public String knowlege;
	public double score;
	public Stage_Exam_Question_List_vo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stage_Exam_Question_List_vo(int id, String easy, String name, String subject, String stage, String knowlege,
			double score) {
		super();
		this.id = id;
		this.easy = easy;
		this.name = name;
		this.subject = subject;
		this.stage = stage;
		this.knowlege = knowlege;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEasy() {
		return easy;
	}
	public void setEasy(String easy) {
		this.easy = easy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getKnowlege() {
		return knowlege;
	}
	public void setKnowlege(String knowlege) {
		this.knowlege = knowlege;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Stage_Exam_Question_List_vo [id=" + id + ", easy=" + easy + ", name=" + name + ", subject=" + subject
				+ ", stage=" + stage + ", knowlege=" + knowlege + ", score=" + score + "]";
	}
	
}
