package cn.xdl.tol.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.xdl.tol.dao.StageMapper;
import cn.xdl.tol.po.SelectStageExamPo;
import cn.xdl.tol.vo.Not_In_Week_Exam_Question_Vo;
import cn.xdl.tol.vo.Stage_Exam_List_Vo;
import cn.xdl.tol.vo.Stage_Exam_Message_vo;
import cn.xdl.tol.vo.Stage_Exam_Question_List_vo;
import cn.xdl.tol.vo.Week_Exam_Message_vo;
import cn.xdl.tol.vo.Week_Exam_Question_List_vo;

@Controller
@Transactional
public class Stage_ExamController {
	@Resource
	public StageMapper stageMapper;
	
	/**
	 *  通过学科的名字查询学科下所有周
	 * @param name 学科名
	 * @return 所有学科的集合
	 */
	@RequestMapping("/zbwstageexamstage.do")
	@ResponseBody
	public List<String> week_exam_week(String name){
		List<String> list = stageMapper.findStageNameBySubject_Name(name);
		return list;
		
	}
	/**
	 * 通过学科、阶段、搜索框内容搜索试卷列表
	 * @param search 搜索框内容
	 * @param subject 学科名
	 * @param stage 阶段名
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 试卷信息列表集合
	 */
	@RequestMapping("/zbwstageexamlist.do")
	@ResponseBody
	public List<Stage_Exam_List_Vo> week_exam_question(String search,String subject,String stage,HttpServletRequest request,HttpServletResponse response){
		SelectStageExamPo oExamPo =new SelectStageExamPo();
		if(!("学科".equals(subject)))oExamPo.setSubject(subject);
		if(!("阶段".equals(stage)))oExamPo.setStage(stage);
		if(!("".equals(search))){
			search="%"+search+"%";
			oExamPo.setSearch(search);}
		List<Stage_Exam_List_Vo> list = stageMapper.findStageExamMessage(oExamPo);
		
		return list;

	}
	/**
	 * 删除试卷
	 * @param id 试卷id
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 啥也没有
	 */
	@RequestMapping("/zbwdeletestageexam.do")
	@ResponseBody
	public List<Object> stage_exam_question(int id,HttpServletRequest request,HttpServletResponse response){
		
		stageMapper.deleteStageExam(id);
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
	@RequestMapping("/zbwfindStageExamQuestion.do")
	public ModelAndView findWeekExamQuestion(@RequestParam(value="pages",defaultValue="1",required=false) int pages,int id,HttpServletRequest request,HttpServletResponse response){
		Stage_Exam_Message_vo message_vo = stageMapper.findStageExamMessageByExamId(id);
		stageMapper.updateExamScore(id, stageMapper.sumDetailsScore(id));
		Page page = PageHelper.startPage(pages, 3);
		List<Stage_Exam_Question_List_vo> list = stageMapper.findStageExamQuestion(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit_test_paper_stage");
		modelAndView.getModel().put("Stage_Exam_Question_List_vo", list);
		modelAndView.getModel().put("page", pages);
		if(page.getTotal()%3==0){
			modelAndView.getModel().put("totalPages", page.getTotal()/3);
		}else{
			modelAndView.getModel().put("totalPages", page.getTotal()/3+1);
		}
		modelAndView.getModel().put("id", id);
		modelAndView.getModel().put("score", message_vo.getScore());
		modelAndView.getModel().put("subject", message_vo.getSubject());
		modelAndView.getModel().put("countQuestion", message_vo.getCountQuestion());
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
	@RequestMapping("/zbwdeletestagequestion.do")
	@ResponseBody
	public List<Object> deleteExamQuestionByExamIdAndQuestionId(int questionId,int examId,HttpServletRequest request,HttpServletResponse response){
		stageMapper.deleteExamQuestionByExamIdAndQuestionId(examId, questionId);
		stageMapper.updateExamScore(examId, stageMapper.sumDetailsScore(examId));
		/**
		 * 调用删除的方法
		 * 调用修改试卷总分的方法
		 */
		List<Object> list = new ArrayList<Object>();
		return list;
		
	}
	
	@RequestMapping("/zbwselectstagequestion.do")
	public ModelAndView deleteExamQuestionByExamIdAndQuestionI(@RequestParam(value="pages",defaultValue="1",required=false) int pages,int id,String subject){
		String week = stageMapper.findStageNameByStageExamId(id);
		List<String> knowlegeName = stageMapper.findKnowlegeNameBySubjectNameAndStageName(subject, week);
		Page page = PageHelper.startPage(pages, 3);
		List<Not_In_Week_Exam_Question_Vo> questionMessage = stageMapper.findNotInStageExamQuestionMessageByQuestionIdAndSubjectNameStageName(id, subject, week);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insert_tests_in_stage");
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
	
	
	@RequestMapping("/zbwinsertStageExamQuestion.do")
	@ResponseBody
	public List<Object> deleteExamQuestionByExamIdAndQuestion(int questionId,int weekId){
		stageMapper.insertStageExamQuestion(weekId, questionId);
		List<Object> list = new ArrayList<Object>();
		return list;
		
	}
	@RequestMapping("/zbwstageexamdisplay.do")
	@ResponseBody
	public List<Object> deleteExamQuestionByExamIdAndQuestio(int id,int status){
		stageMapper.updateStageExamDisplay(id, status);
		List<Object> list = new ArrayList<Object>();
		return list;
		
	}
	
	
	
}
