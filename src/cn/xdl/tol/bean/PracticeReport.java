package cn.xdl.tol.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 
 * @author 程帅
 *
 */
public class PracticeReport implements Serializable{

	/**
	 * 知识点名字
	 */
	private String knowlege_name;
	/**
	 * 刷题数量
	 */
	private Integer count;
	/**
	 * 刷题成绩
	 */
	private Double score;
	/**
	 * 刷题时间
	 */
	private Timestamp time;
	
	public PracticeReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PracticeReport(String knowlege_name, Integer count, Double score, Timestamp time) {
		super();
		this.knowlege_name = knowlege_name;
		this.count = count;
		this.score = score;
		this.time = time;
	}

	public String getKnowlege_name() {
		return knowlege_name;
	}

	public void setKnowlege_name(String knowlege_name) {
		this.knowlege_name = knowlege_name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((knowlege_name == null) ? 0 : knowlege_name.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		PracticeReport other = (PracticeReport) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (knowlege_name == null) {
			if (other.knowlege_name != null)
				return false;
		} else if (!knowlege_name.equals(other.knowlege_name))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PracticeReport [knowlege_name=" + knowlege_name + ", count=" + count + ", score=" + score + ", time="
				+ time + "]";
	}
	
	
}
