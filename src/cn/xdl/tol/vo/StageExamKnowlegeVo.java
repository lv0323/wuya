package cn.xdl.tol.vo;

public class StageExamKnowlegeVo {
	private int knowlege_id;
	private int count;
	private int rightCount;
	private String knowlege_name;
	private double grade;
	private double rightGrade ;
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
	public int getRightCount() {
		return rightCount;
	}
	public void setRightCount(int rightCount) {
		this.rightCount = rightCount;
	}
	public String getKnowlege_name() {
		return knowlege_name;
	}
	public void setKnowlege_name(String knowlege_name) {
		this.knowlege_name = knowlege_name;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Double getRightGrade() {
		return rightGrade;
	}
	public void setRightGrade(Double rightGrade) {
		this.rightGrade = rightGrade;
	}
	@Override
	public String toString() {
		return "StageExamKnowlegeVo [knowlege_id=" + knowlege_id + ", count=" + count + ", rightCount=" + rightCount
				+ ", knowlege_name=" + knowlege_name + ", grade=" + grade + ", rightGrade=" + rightGrade + "]";
	}
	
}
