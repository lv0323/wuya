package cn.xdl.tol.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xdl.tol.bean.PracticeReport;
import cn.xdl.tol.bean.StageReport;
import cn.xdl.tol.bean.SumScore;
import cn.xdl.tol.bean.WeekReport;
import cn.xdl.tol.dao.ReportMapper;

/**
 * 用来获取所有测试报告信息和制定学习计划的分数信息
 * @author CS
 *
 */
@Controller
@Transactional
public class GetAllReportsAndPlanController {

	@Resource
	private ReportMapper reportMapper;
	/**
	 * 获取所有周测报告对象列表
	 * @param user_id 	用户的ID
	 * @return	周测报告对象集合
	 */
	@RequestMapping("/weekReps/list.do")
	@ResponseBody
	public List getWeekReport(int user_id){
		List<WeekReport> list = reportMapper.findWeekReport(user_id);
		//System.out.println(list.toString());
		return list;
	}
	/**
	 * 获取所有阶段测试报告对象列表
	 * @param user_id	用户的ID
	 * @return	阶段测试报告对象集合
	 */
	@RequestMapping("/stageReps/list.do")
	@ResponseBody
	public List getStageReport(int user_id){
		List<StageReport> list = reportMapper.findStageReport(user_id);
		//System.out.println(list.toString());
		return list;
	}
	/**
	 * 获取所有刷题测试报告对象列表
	 * @param user_id	用户的ID
	 * @return	刷题报告对象集合
	 */
	@RequestMapping("/practiceReps/list.do")
	@ResponseBody
	public List getPracticeReport(int user_id){
		List<PracticeReport> list = reportMapper.findPracticeReport(user_id);
		//System.out.println(list.toString());
		return list;
	}
	/**
	 * 获取所有周测试分数对象的方法
	 * @param user_id	用户的ID
	 * @return	周测试分数对象
	 */
	@RequestMapping("/week/plan.do")
	@ResponseBody
	public SumScore getWeekPlan(int user_id){
		SumScore weekScore = reportMapper.findWeekScore(user_id);
		//System.out.println(weekScore);
		return weekScore;
	}
	/**
	 * 获取所有阶段测试分数对象的方法
	 * @param user_id	用户的ID
	 * @return	阶段测试分数对象
	 */
	@RequestMapping("/stage/plan.do")
	@ResponseBody
	public SumScore getStagePlan(int user_id){
		SumScore stageScore = reportMapper.findStageScore(user_id);
		//System.out.println(stageScore);
		return stageScore;
	}
	/**
	 * 获取所有刷题测试平均分数方法
	 * @param user_id	用户的ID
	 * @return	刷题测试平均分
	 */
	@RequestMapping("/practice/plan.do")
	@ResponseBody
	public double execute(int user_id){
		double practiceScore = reportMapper.findPracticeScore(user_id);
		//System.out.println(practiceScore);
		return practiceScore;
	}
}
