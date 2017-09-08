package cn.xdl.tol.vo;

public class Stage_Exam_Message_vo {
	private int id;
	private String subject;
	private int countQuestion;
	private double score;
	public Stage_Exam_Message_vo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stage_Exam_Message_vo(int id, String subject, int countQuestion, double score) {
		super();
		this.id = id;
		this.subject = subject;
		this.countQuestion = countQuestion;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getCountQuestion() {
		return countQuestion;
	}
	public void setCountQuestion(int countQuestion) {
		this.countQuestion = countQuestion;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Stage_Exam_Message_vo [id=" + id + ", subject=" + subject + ", countQuestion=" + countQuestion
				+ ", score=" + score + "]";
	}	
	
}
