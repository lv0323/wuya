package cn.xdl.tol.bean;
/**
 * 用户所有分数对象
 * @author CS
 *
 */
public class SumScore {

	/**
	 * 用户做过的试卷的总分
	 */
	private double testScore;
	/**
	 * 用户得分总分
	 */
	private double userScore;
	
	public SumScore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SumScore(double testScore, double userScore) {
		super();
		this.testScore = testScore;
		this.userScore = userScore;
	}

	public double getTestScore() {
		return testScore;
	}

	public void setTestScore(double testScore) {
		this.testScore = testScore;
	}

	public double getUserScore() {
		return userScore;
	}

	public void setUserScore(double userScore) {
		this.userScore = userScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(testScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(userScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SumScore other = (SumScore) obj;
		if (Double.doubleToLongBits(testScore) != Double.doubleToLongBits(other.testScore))
			return false;
		if (Double.doubleToLongBits(userScore) != Double.doubleToLongBits(other.userScore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SumScore [testScore=" + testScore + ", userScore=" + userScore + "]";
	}
	
	
	
}
