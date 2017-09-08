package cn.xdl.tol.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 周测试卷表
 * @author sunyu
 *
 */
public class Week_Exam implements Serializable{
	/**
	 * 周测试卷编号
	 */
	private int week_exam_id;
	/**
	 * 周测试卷名字
	 */
	private String week_exam_name;
	/**
	 * 测试时间
	 */
	private Timestamp time;
	/**
	 * 周编号
	 */
	private Integer weekly_type_id;
	/**
	 * 总分
	 */
	private double tatal_points;
	/**
	 * 禁用
	 */
	private int  display;
	
	
	public double getTatal_points() {
		return tatal_points;
	}
	public void setTatal_points(double tatal_points) {
		this.tatal_points = tatal_points;
	}
	public int getWeek_exam_id() {
		return week_exam_id;
	}
	public void setWeek_exam_id(int week_exam_id) {
		this.week_exam_id = week_exam_id;
	}
	public String getWeek_exam_name() {
		return week_exam_name;
	}
	public void setWeek_exam_name(String week_exam_name) {
		this.week_exam_name = week_exam_name;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Integer getWeekly_type_id() {
		return weekly_type_id;
	}
	public void setWeekly_type_id(Integer weekly_type_id) {
		this.weekly_type_id = weekly_type_id;
	}
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public int getOn_delete() {
		return on_delete;
	}
	public void setOn_delete(int on_delete) {
		this.on_delete = on_delete;
	}
	/**
	 * 删除
	 */
	private int  on_delete;
	

	/**
	 * 
	 * @param week_exam_id 周测试卷编号
	 * @param week_exam_name 周测试卷名字
	 * @param time 测试时间
	 * @param weekly_type_id 周编号
	 * @param display 禁用
	 * @param delete 删除
	 */
	public Week_Exam(int week_exam_id, String week_exam_name, Timestamp time, Integer weekly_type_id,
			double tatal_points, int display, int on_delete) {
		super();
		this.week_exam_id = week_exam_id;
		this.week_exam_name = week_exam_name;
		this.time = time;
		this.weekly_type_id = weekly_type_id;
		this.tatal_points = tatal_points;
		this.display = display;
		this.on_delete = on_delete;
	}
	
	@Override
	public String toString() {
		return "Week_Exam [week_exam_id=" + week_exam_id + ", week_exam_name=" + week_exam_name + ", time=" + time
				+ ", weekly_type_id=" + weekly_type_id + ", tatal_points=" + tatal_points + ", display=" + display
				+ ", on_delete=" + on_delete + "]";
	}
	public Week_Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + week_exam_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Week_Exam other = (Week_Exam) obj;
		if (week_exam_id != other.week_exam_id)
			return false;
		return true;
	}
	
}
