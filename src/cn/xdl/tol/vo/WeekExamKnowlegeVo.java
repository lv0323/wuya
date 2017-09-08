package cn.xdl.tol.vo;

public class WeekExamKnowlegeVo {
	private int knowlege_id;
	private int count;
	private int rightCount;
	private String knowlege_name;
	private double grade;
	private double rightGrade;
	
	
	public int getRightCount() {
		return rightCount;
	}
	public void setRightCount(int rightCount) {
		this.rightCount = rightCount;
	}
	public double getRightGrade() {
		return rightGrade;
	}
	public void setRightGrade(double rightGrade) {
		this.rightGrade = rightGrade;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getKnowlege_id() {
		return knowlege_id;
	}
	public void setKnowlege_id(int knowlege_id) {
		this.knowlege_id = knowlege_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getKnowlege_name() {
		return knowlege_name;
	}
	public void setKnowlege_name(String knowlege_name) {
		this.knowlege_name = knowlege_name;
	}
	@Override
	public String toString() {
		return "WeekExamKnowlegeVo [knowlege_id=" + knowlege_id + ", count=" + count + ", rightCount=" + rightCount
				+ ", knowlege_name=" + knowlege_name + ", grade=" + grade + ", rightGrade=" + rightGrade + "]";
	}
	
	
	
}
