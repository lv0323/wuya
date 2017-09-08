package cn.xdl.tol.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.service.PracticeService;
import cn.xdl.tol.vo.Practice_Paper_Easy_VO;

/**
 * 与Practice有关的Controller
 * @author Zs
 */
@Controller
@Transactional
public class Practice_Handle_Controller {
	/**
	 * PracticeService对象，用于获取有关practice的操作
	 */
	@Resource
	private PracticeService practiceservice;
	
	/**
	 * 向页面显示题库中包含的学科
	 * @return 返回包含的学科集合
	 */
	@RequestMapping("/choose_practice.do")
	private ModelAndView practiceShowInfo(String msg) {
		List<Subject> findSubjectHaveQuestion = practiceservice.findSubjectHaveQuestion();
		ModelAndView mav = new ModelAndView();
		mav.getModel().put("vo", findSubjectHaveQuestion);
		if ("noq".equals(msg)) {
			mav.getModel().put("msg", "没有相关试题，请重新选择!");
		}
		mav.setViewName("choose_practice_exam");
		return mav;
	}
	
	/**
	 * 根据用户的学科选择发送相关学科知识点和难度
	 * @param subject_id 用户选择的学科id
	 * @return 返回对应学科知识点和难度
	 */
	@RequestMapping("/showChooseInfo.do")
	@ResponseBody
	private Practice_Paper_Easy_VO showVo(Integer subject_id) {
		Subject subject = practiceservice.findSubjectById(subject_id);
		Practice_Paper_Easy_VO vo = practiceservice.getPractice_Paper_Easy_VO(subject_id);
		return vo;
	}
	/**
	 * 通过用户刷题选择进行试题筛选转至刷题界面
	 * @param knowledge_ids 用户的选择知识点
	 * @param easy_type 用户选择的难度
	 * @return 返回刷题界面的ModelAndView
	 * @throws UnsupportedEncodingException 抛出转码异常
	 */
	@RequestMapping("/practice_exam.do")
	private ModelAndView practice_Exam(String knowledge_ids, String easy_type) throws UnsupportedEncodingException {
		String easy = new String(easy_type.getBytes("iso-8859-1"),"utf-8");
		List<Question> practicePaper = practiceservice.getPracticePaper(knowledge_ids, easy);
		Integer paperScore = practiceservice.getPracticePaperScore(knowledge_ids, easy);
		ModelAndView mav = new ModelAndView();
		if (!practicePaper.isEmpty()) {//判断是否有试题
			mav.getModel().put("paper", practicePaper);
			mav.getModel().put("paperScore", paperScore);
			mav.setViewName("practice_exam");
		} else {//没有试题返回选择页面，并回显
			mav.setViewName("redirect:/choose_practice.do?msg=noq");
		}
		return mav;
	}
	
	/**
	 * 处理答题结果并导向刷题报告界面
	 * @param request 答题页面的request对象
	 * @return 返回答题报告的ModelAndView
	 */
	@RequestMapping("/finish_practice.do")
	private ModelAndView finish_Practice(HttpServletRequest request) {
		String total_str = request.getParameter("total_count");
		int total = Integer.parseInt(total_str);
		String[] answer = new String[total];
		//不断获取用户答题答案与题号
		for (int i = 1; i <= total; i++) {
			answer[i-1] = request.getParameter(String.valueOf(i));
		}
		//获取当前用户id
		HttpSession session = request.getSession();
		session.setAttribute("user_id", 3);
		Integer user_id = (Integer) session.getAttribute("user_id");
		String scorestr = request.getParameter("total_score");
		int total_score = Integer.parseInt(scorestr);
		
		//提交考试
		Map<String, Object> vomap = practiceservice.submitPractice(total, answer, user_id, total_score);
		/*vomap.get("questions");
		vomap.get("vo");
		vomap.get("total_score");
		vomap.get("user_score");
		vomap.get("rank");
		vomap.get("uchoose");*/
		//创建ModelAndView对象
		ModelAndView mav = new ModelAndView();
		mav.getModel().put("vo", vomap.get("vo"));
		mav.getModel().put("total_score", vomap.get("total_score"));
		mav.getModel().put("user_score", vomap.get("user_score"));
		mav.getModel().put("rank", vomap.get("rank"));
		mav.getModel().put("time", vomap.get("time"));
		mav.getModel().put("user", vomap.get("user"));
		mav.getModel().put("topuname", vomap.get("topuname"));
		mav.getModel().put("topucount", vomap.get("topucount"));
		mav.setViewName("practice_report");
		return mav;
	}
	
}
