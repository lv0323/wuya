package cn.xdl.tol.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;

import cn.xdl.tol.bean.QuestionAndSubjectAndKnowlege;
import cn.xdl.tol.bean.Result;
import cn.xdl.tol.service.QuestionService;

/**
 * 问题，组卷相关控制层
 * 
 * @author zhangjing
 *
 */

@Controller
@Transactional
public class QuestionController {
	
	@Resource
	private QuestionService questionService;
	
	/**
	 * 增加一套试题
	 * 
	 * @param subjectname
	 *            学科名
	 * @param questdata
	 *            试题编号组
	 * @param tttype
	 *            周还是阶段卷
	 * @param typedetial
	 *            第几周或第几阶段
	 * @param examname
	 *            新试题名
	 * @return
	 */
	@RequestMapping("addexam.do")
	@ResponseBody
	private Object addExam(String subjectname, String questdata, String tttype, String typedetial, String examname) {

		// 插入一套试卷
		int addexam = questionService.addexam(subjectname, questdata, tttype, typedetial, examname);
		if (addexam == 0) {
			//表示试卷插入失败
			return -1;

		}
		return addexam;

	}

	/**
	 * 按要求随机查询试题
	 * 
	 * @param district
	 *            周或者阶段类型
	 * @param tttype
	 *            学科名
	 * @param subjectname
	 *            周号或者阶段号
	 * @return
	 */
	@RequestMapping("getallquestionhh.do")
	@ResponseBody
	private Result getQuest1(String district, String tttype, String subjectname) {

		// 获取用户所查询的试题
		List<QuestionAndSubjectAndKnowlege> f = questionService.findquestion2(district, tttype, subjectname);
		Result result = new Result();
		if (f == null) {
			// 状态码为0 表示查询没有结果
			result.setStatus(0);
			result.setBody("没有相关试题");
		} else {
			// 状态码为1 表示查询有结果
			result.setStatus(1);
			result.setBody(f);
		}
		return result;

	}

	/**
	 * 智能按要求随机抽取一道试题
	 * 
	 * @param district
	 *            周或者阶段类型
	 * @param tttype
	 *            学科名
	 * @param subjectname
	 *            周号或者阶段号
	 * @return
	 */
	@RequestMapping("getrandomquest.do")
	@ResponseBody
	private Result getQuest2(String district, String tttype, String subjectname, String questnumber) {
		Result result = new Result();

		// 获取用户选择的条件查询到所有的试题
		List<QuestionAndSubjectAndKnowlege> f = questionService.findquestion2(district, tttype, subjectname);
	

		
		if (f == null) {
			// 状态码为0 表示查询没有结果
			result.setStatus(0);
			result.setBody("没有相关试题");
		}
		else {
			//数据库有相关条件的试题
			
			List<QuestionAndSubjectAndKnowlege> m = new ArrayList<QuestionAndSubjectAndKnowlege>();
			// 根据用户所输入提数随机抽取试题
			
			// 判断数据库符合条件的题目数是否大于要抽取的数量
			if (f.size() > Integer.parseInt(questnumber)) {
				// 数据库符合条件的题目数大于要抽取的数量，抽取
				Random d = new Random();
				int ppp = -1;
				int[] qwi=new int[ Integer.parseInt(questnumber)+1];
				// 随机抽取出一道题，放入m集合中，最终返回
				for (int z = 1; z <= Integer.parseInt(questnumber); z++) {
					ppp = d.nextInt(f.size());
					qwi[z]=ppp;
					//去除重复
					for(int qw=1;qw<z;qw++){
						if(qwi[z]==qwi[qw]){
							z--;
						}
					}
					
				}
				for (int z = 1; z <= Integer.parseInt(questnumber); z++) {
					m.add(f.get(qwi[z]));
				}
				
				// 状态码为1 表示抽取成功
				result.setStatus(1);
				result.setBody(m);
			} else {
				// 数据库符合条件的题目数小于要抽取的数量，返回状态码—1；表示试题数不足
				result.setStatus(-1);
				result.setBody("题库试题数量不足，请重新输入试题数量");
			}
		}
		return result;

	}

	/**
	 * 多条件(学科名,知识点名,问题关键字)选择查询,
	 * 
	 * @param subjectname
	 *            学科名
	 * @param knowlegename
	 *            知识点名
	 * @param questionname
	 *            问题关键字
	 * @param request
	 * @return
	 */
	@RequestMapping("getallquestion2.do")
	@ResponseBody
	private Result getKnowlege(/*@RequestParam(value="pages",defaultValue="1",required=false) int pages,*/String subjectname, String knowlegename, String questionname,
			HttpServletRequest request) {
		
		
		/*
		//分页时每页显示5条
		Page page = PageHelper.startPage(pages, 5);
		*/
		
		// 获取用户所查询的试题
		List<QuestionAndSubjectAndKnowlege> f = questionService.findquestion1(subjectname, knowlegename, questionname);
		
		
		/*
		//总页数计算与存储
		if(page.getTotal()%5==0){
			request.getSession().setAttribute("totalPages", page.getTotal()/5);
		}else{
			request.getSession().setAttribute("totalPages", page.getTotal()/5+1);
		}
		System.out.println(page.getTotal()/5);
		//返回当前页数
		request.getSession().setAttribute("page", pages);*/
		
		Result result = new Result();
		if (f == null) {
			// 状态码为0 表示查询没有结果
			result.setStatus(0);
			result.setBody("没有相关试题");
		} else {
			request.getSession().setAttribute("questions", f);
			// 状态码为1 表示查询有结果
			result.setStatus(1);
			result.setBody(f);
			
		}
		return result;

	}

	/**
	 * 删除一道试题
	 * 
	 * @param questionid
	 *            试题id
	 * @return
	 */
	@RequestMapping("removequestion.do")
	@ResponseBody
	private int removeQuest(String questionid) {
		// 将接受到的id由string类型改为int型
		int que = Integer.parseInt(questionid);
		int r = questionService.removeQuest(que);
		return r;
	}

	/**
	 * 根据题号查询试题所有信息,包括知识点名和学科名
	 * 
	 * @param questionid
	 *            题号
	 * @return
	 */
	@RequestMapping("findquest.do")
	@ResponseBody
	private Result findQuestById(String questionid) {
		// 将接受到的id由string类型改为int型
		int que = Integer.parseInt(questionid);
		List<QuestionAndSubjectAndKnowlege> r = questionService.findQuestById(que);
		Result result = new Result();
		if (r == null) {
			// 状态码为0 表示查询没有结果
			result.setStatus(0);
			result.setBody("没有相关试题");
		} else {
			// 状态码为1 表示查询有结果
			result.setStatus(1);
			result.setBody(r);
		}
		return result;
	}

	/**
	 * 根据题号更改一道试题
	 * 
	 * @param question_id
	 *            试题id
	 * @param easy_type
	 *            难易程度
	 * @param question_name
	 *            试题名
	 * @param score
	 *            成绩
	 * @param option_A
	 *            A选项
	 * @param option_D
	 *            A选项
	 * @param answer
	 *            答案
	 * @param option_B
	 *            B选项
	 * @param option_C
	 *            C选项
	 * @return 影响行数
	 */
	@RequestMapping("updatequest.do")
	@ResponseBody
	private int updateQuestById(String question_id, String easy_type, String question_name, String score,
			String option_A, String option_D, String answer, String option_B, String option_C) {

		// 将接受到的id由string类型改为int型
		int que = Integer.parseInt(question_id);

		int r = questionService.UpdateQuestById(que, easy_type, question_name, score, option_A, option_D, answer,
				option_B, option_C);

		return 3;
	}

	/**
	 * 增加试题
	 * 
	 * @param subjectname
	 *            学科名
	 * @param knowlegename
	 *            知识点名
	 * @param easy_type
	 *            难易程度
	 * @param question_name
	 *            试题名
	 * @param score
	 *            成绩
	 * @param option_A
	 *            A选项
	 * @param option_D
	 *            A选项
	 * @param answer
	 *            答案
	 * @param option_B
	 *            B选项
	 * @param option_C
	 *            C选项
	 * @return 影响行数
	 */
	@RequestMapping("addquest.do")
	@ResponseBody
	private int addQuest(String subjectname, String knowlegename, String question_name, String score, String option_A,
			String option_D, String answer, String option_B, String option_C, String easy_type) {

		// 插入试题
		int r = questionService.addQuestById(subjectname, knowlegename, question_name, score, option_A, option_D,
				answer, option_B, option_C, easy_type);

		return r;

	}
}
