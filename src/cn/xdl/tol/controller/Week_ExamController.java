package cn.xdl.tol.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.Weekly_Type;
import cn.xdl.tol.dao.Weekly_TypeMapper;
import cn.xdl.tol.po.SelectWeekExamPo;
import cn.xdl.tol.vo.Not_In_Week_Exam_Question_Vo;
import cn.xdl.tol.vo.Week_Exam_List_Vo;
import cn.xdl.tol.vo.Week_Exam_Message_vo;
import cn.xdl.tol.vo.Week_Exam_Question_List_vo;
import net.sf.json.JSONArray;

@Controller
public class Week_ExamController {
	@Resource
	public Weekly_TypeMapper weekly_TypeMapper;
	/**
	 * 查询所有学科
	 * @return 所有学科的集合
	 */
	@RequestMapping("/zbwweekexamsubject.do")
	@ResponseBody
	@Transactional
	public List<Subject> week_exam(){
		List<Subject> list = weekly_TypeMapper.findAllSubject();
		return list;
		
	}
	/**
	 *  通过学科的名字查询学科下所有周
	 * @param name 学科名
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 所有周名的集合
	 */
	@RequestMapping("/zbwweekexamweek.do")
	@ResponseBody
	@Transactional
	public List<Weekly_Type> week_exam_week(String name,HttpServletRequest request,HttpServletResponse response){
		List<Weekly_Type> list = weekly_TypeMapper.findWeekly_TypeBySubject_Name(name);
		return list;
		
	}
	/**
	 * 通过学科、周、搜索框内容搜索试卷列表
	 * @param search 搜索框内容
	 * @param subject 学科名
	 * @param week 周名
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 试卷信息列表集合
	 */
	@RequestMapping("/zbwweekexamlist.do")
	@ResponseBody
	@Transactional
	public List<Week_Exam_List_Vo> week_exam_question(String search,String subject,String week,HttpServletRequest request,HttpServletResponse response){
		SelectWeekExamPo selectWeekExamPo = new SelectWeekExamPo();
		if(!("学科".equals(subject)))selectWeekExamPo.setSubject(subject);
		if(!("周".equals(week)))selectWeekExamPo.setWeek(week);
		if(!("".equals(search))){
			search="%"+search+"%";
			selectWeekExamPo.setSearch(search);}
		List<Week_Exam_List_Vo> list = weekly_TypeMapper.findWeekExamMessage(selectWeekExamPo);
		
		return list;

	}
	/**
	 * 删除试卷
	 * @param id 试卷id
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 啥也没有
	 */
	@RequestMapping("/zbwdeleteexam.do")
	@ResponseBody
	@Transactional
	public List<Object> week_exam_question(int id,HttpServletRequest request,HttpServletResponse response){
		
		weekly_TypeMapper.deleteWeekExam(id);
		List<Object> list = new ArrayList<Object>();
		return list;
		
	}
	/**
	 * 通过试卷编号获取所有试题
	 * @param pages 当前页
	 * @param id 试卷编号
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 试题对象集合的试图
	 */
	@RequestMapping("/zbwfindWeekExamQuestion.do")
	@Transactional
	public ModelAndView findWeekExamQuestion(@RequestParam(value="pages",defaultValue="1",required=false) int pages,int id,HttpServletRequest request,HttpServletResponse response){
		Week_Exam_Message_vo exam_Message = weekly_TypeMapper.findWeekExamMessageByExamId(id);
		weekly_TypeMapper.updateExamScore(id, weekly_TypeMapper.sumDetailsScore(id));
		Page page = PageHelper.startPage(pages, 3);
		List<Week_Exam_Question_List_vo> list = weekly_TypeMapper.findWeekExamQuestion(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit_test_paper_week");
		modelAndView.getModel().put("week_Exam_Question_List_vos", list);
		modelAndView.getModel().put("page", pages);
		if(page.getTotal()%3==0){
			modelAndView.getModel().put("totalPages", page.getTotal()/3);
		}else{
			modelAndView.getModel().put("totalPages", page.getTotal()/3+1);
		}
		modelAndView.getModel().put("id", id);
		modelAndView.getModel().put("score", exam_Message.getScore());
		modelAndView.getModel().put("subject", exam_Message.getSubject());
		modelAndView.getModel().put("countQuestion", exam_Message.getCountQuestion());
		return modelAndView;
		
	}
	/**
	 * 根据试卷编号和试题编号在试卷表中删除该试题
	 * @param questionId 试题编号
	 * @param examId 试卷编号
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 啥也没有
	 */
	@RequestMapping("/zbwdeletequestion.do")
	@ResponseBody
	@Transactional
	public List<Object> deleteExamQuestionByExamIdAndQuestionId(int questionId,int examId,HttpServletRequest request,HttpServletResponse response){
		weekly_TypeMapper.deleteExamQuestionByExamIdAndQuestionId(examId, questionId);
		weekly_TypeMapper.updateExamScore(examId, weekly_TypeMapper.sumDetailsScore(examId));
		/**
		 * 调用删除的方法
		 * 调用修改试卷总分的方法
		 */
		List<Object> list = new ArrayList<Object>();
		return list;
		
	}

	@RequestMapping("/zbwselectquestion.do")
	@Transactional
	public ModelAndView deleteExamQuestionByExamIdAndQuestionI(@RequestParam(value="pages",defaultValue="1",required=false) int pages,int id,String subject){
		String week = weekly_TypeMapper.findWeekNameByWeekExamId(id);
		List<String> knowlegeName = weekly_TypeMapper.findKnowlegeNameBySubjectNameAndWeekName(subject, week);
		Page page = PageHelper.startPage(pages, 3);
		List<Not_In_Week_Exam_Question_Vo> questionMessage = weekly_TypeMapper.findNotInWeekExamQuestionMessageByQuestionIdAndSubjectNameWeekName(id, subject, week);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insert_tests_in_week");
		modelAndView.getModel().put("weekExamId", id);
		modelAndView.getModel().put("subject", subject);
		modelAndView.getModel().put("questionMessages", questionMessage);
		modelAndView.getModel().put("knowlegeNames", knowlegeName);
		modelAndView.getModel().put("page", pages);
		if(page.getTotal()%3==0){
			modelAndView.getModel().put("totalPages", page.getTotal()/3);
		}else{
			modelAndView.getModel().put("totalPages", page.getTotal()/3+1);
		}
		return modelAndView;
	}
	@RequestMapping("/zbwinsertWeekExamQuestion.do")
	@ResponseBody
	@Transactional
	public List<Object> deleteExamQuestionByExamIdAndQuestion(int questionId,int weekId){
		weekly_TypeMapper.insertWeekExamQuestion(weekId, questionId);
		List<Object> list = new ArrayList<Object>();
		return list;
		
	}
	@RequestMapping("/zbwweekexamdisplay.do")
	@ResponseBody
	@Transactional
	public List<Object> deleteExamQuestionByExamIdAndQuestio(int id,int status){
		weekly_TypeMapper.updateWeekExamDisplay(id, status);
		List<Object> list = new ArrayList<Object>();
		return list;
		
	}
}
