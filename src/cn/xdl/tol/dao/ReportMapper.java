package cn.xdl.tol.dao;

import java.util.List;

import cn.xdl.tol.bean.PracticeReport;
import cn.xdl.tol.bean.StageReport;
import cn.xdl.tol.bean.SumScore;
import cn.xdl.tol.bean.WeekReport;

public interface ReportMapper {

	/**
	 * 查找周测报告内容的方法
	 * @param user_id	用户的ID
	 * @return 周测报告的对象集合
	 */
	List<WeekReport> findWeekReport(int user_id);
	/**
	 * 查找阶段测试报告内容的方法
	 * @param user_id	用户的ID
	 * @return 阶段测试报告的对象集合
	 */
	List<StageReport> findStageReport(int user_id);
	/**
	 * 查找刷题报告内容的方法
	 * @param user_id	用户的ID
	 * @return 用户刷题报告的对象集合
	 */
	List<PracticeReport> findPracticeReport(int user_id);
	/**
	 * 根据周测信息得到总成绩的方法
	 * @param user_id 用户的ID
	 * @return 用户周测总成绩的对象
	 */
	SumScore findWeekScore(int user_id);
	/**
	 * 根据阶段测试信息得到总成绩的方法
	 * @param user_id 用户的ID
	 * @return 用户阶段总成绩的对象
	 */
	SumScore findStageScore(int user_id);
	/**
	 * 根据刷题测试信息得到平均成绩的方法
	 * @param user_id 用户的ID
	 * @return 用户刷题平均成绩的对象
	 */
	double findPracticeScore(int user_id);
}
