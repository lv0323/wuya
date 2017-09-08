package cn.xdl.tol.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Stage;
import cn.xdl.tol.bean.Stage_Answer;
import cn.xdl.tol.bean.Stage_Exam;
import cn.xdl.tol.bean.Stage_Grade;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.User;
import cn.xdl.tol.service.StageExamRandomService;
import cn.xdl.tol.vo.StageExamKnowlegeVo;
import cn.xdl.tol.vo.StageExamUserQuestionVo;

@Controller
@Transactional
public class StageExamQuestionController {
	@Resource
	private StageExamRandomService service;
	
	@RequestMapping("/getStageExamQuestion.do")
	public ModelAndView getStageExamQuestion(HttpServletRequest request,int stage_id){
		//调用到接口传入阶段id获得阶段测试卷信息，阶段测试卷题
		Map<String, Object> maps = service.getStageExamRandomId(stage_id);
		
		//获得阶段测试卷试题
		List<Question> qu= (List) maps.get("question");
		//获得阶段测试卷信息
		Stage_Exam se = (Stage_Exam) maps.get("stageexam");
		//创建视图对象
		ModelAndView mav = new ModelAndView();
		//指定展示的视图名称
		mav.setViewName("stageexamonline");
		//放入model中
		mav.getModel().put("questions", qu);
		mav.getModel().put("se", se);
		//返回视图对象
		return mav;
	} 
	/**
	 * 前台跳转到学科选择页面请求这个地址，查询数据库学科表
	 * @return stage_choose_exam和学科集合
	 * 
	 */
	@RequestMapping("/subjectList.do")
	public ModelAndView findSubjectList(){
		List<Subject> subjectList = service.getSubjectList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stage_choose_exam");
		mav.getModel().put("subjectlist",subjectList);
		return mav;
	}
	/**
	 * 传入学科id查询数据库阶段表
	 * @param subject_id 学科id
	 * @return 阶段集合
	 */
	@RequestMapping("/stageList.do")
	@ResponseBody
	public List<Stage> getStageListById(HttpServletRequest request,Integer subject_id){
		List<Stage> stageList = service.getStageList(subject_id);
		request.getSession().setAttribute("subject_id", subject_id);
		return stageList;
	}
	/**
	 * 查询数据库阶段试卷表，判断试卷集合的大小是否为0
	 * @param stage_id 阶段id
	 * @return json字符串
	 */
	@RequestMapping("/getStageEaxmList.do")
	@ResponseBody
	public String getStageEaxm(HttpServletRequest request,int stage_id){
		List<Stage_Exam> list = service.getStageExam(stage_id);
		request.getSession().setAttribute("stage_id", stage_id);
		String str=null;
		if(list.size()==0){
			 str="{\"errorCode\":0}";
		}else{
			 str="{\"errorCode\":1}";
		}
		return str;
	}
	@RequestMapping("/updateScore.do")
	public ModelAndView getAnalyzeBook(HttpServletRequest request){
		//从session中获得用户的id
		request.getSession().setAttribute("user_id", 2);
		int user_id =(int) request.getSession().getAttribute("user_id");
		//获得学科id
		Integer subject_id = (Integer)request.getSession().getAttribute("subject_id");
		//调用方法获得阶段测试卷试题
		int stage_exam_id = (int)request.getSession().getAttribute("stage_exam_id");
		List<Question> list = service.getQuestionListById(stage_exam_id);
		//声明一个类型的总分
		Double score=0.0;
		//创建成绩表对象
		Stage_Grade stage_grade = new Stage_Grade();
		stage_grade.setUser_id(user_id);
		stage_grade.setStage_exam_id(stage_exam_id);
		stage_grade.setSubject_id(subject_id);
		Timestamp tt = new Timestamp(System.currentTimeMillis());
		stage_grade.setTime(tt);
		//传入成绩表对象插入成绩表
		service.insertIntoStageGrade(stage_grade);
		//通过用户id和用户插入的时间查询成绩表获得成绩表对象获得对象自动生成的成绩表编号
		Stage_Grade sgs = service.findFromStageGrade(stage_grade);
		request.getSession().setAttribute("stage_grade_id", sgs.getStage_grade_id());
		for (Question question : list) {
			String answer = request.getParameter(question.getQuestion_id()+"");
			if(question.getAnswer().equalsIgnoreCase(answer)){
				score+=question.getScore();
				Stage_Answer sa = new Stage_Answer();
				sa.setStage_grade_id(sgs.getStage_grade_id());
				sa.setQuestion_id(question.getQuestion_id());
				sa.setIs_right(1);
				sa.setUser_answer(answer);
				//边循环遍历边往答案表中插入数据
				service.insertIntoStageAnswer(sa);
			}else{
				Stage_Answer sa = new Stage_Answer();
				sa.setStage_grade_id(sgs.getStage_grade_id());
				sa.setQuestion_id(question.getQuestion_id());
				sa.setUser_answer(answer);
				sa.setIs_right(0);
				//边循环遍历边往答案表中插入数据
				service.insertIntoStageAnswer(sa);
			}
			//通过试卷id获得成绩表对象
		}
	
		//通过成绩表编号插入算出的总成绩
		Stage_Grade sgd = new Stage_Grade();
		sgd.setGrade(score);
		sgd.setStage_grade_id(sgs.getStage_grade_id());
		service.updateScore(sgd);
		//返回跳转的页面视图
		ModelAndView mav = new ModelAndView();
		List<StageExamKnowlegeVo> stageExam = service.getStageExamKnowlege(stage_exam_id, sgs.getStage_grade_id());
		mav.getModel().put("stageExamKnowlege", stageExam);
			
			User user = service.getUserByUserId(user_id);
			mav.getModel().put("user", user);
			mav.setViewName("stage_report");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
			String stt = sdf.format(tt);
			mav.getModel().put("stage_exam_time", stt);
			Stage_Exam stage_exam_ms = service.getStageExamByStageExamId(stage_exam_id);
			mav.getModel().put("stage_exam_ms", stage_exam_ms);
			Double newScore = score*100/stage_exam_ms.getTatal_points();
			mav.getModel().put("grade", newScore);
			String rank = null;
			String Analyz =null;
			 if(newScore<=60){
				 rank="4";
				 Analyz="你这个阶段学的是真不好，不要再艾欧尼亚待着了";
			 }else if(newScore<=70){
				 rank="3";
				 Analyz="你这个阶段学的还可以继续努力加油啊！！";
			 }else if(newScore<=80){
				 rank="2";
				 Analyz="你可以做下一个阶段了";
			 }else{
				 rank="1";
				 Analyz="恭喜你你可以去学其他的了";
			 }
			 mav.getModel().put("rank", rank);
			 mav.getModel().put("Analyz", Analyz);
			return mav;
			
	}
	@RequestMapping("/getUserQuestion.do")
	public ModelAndView getUserQuestionAnswer(int stage_grade_id,int stage_exam_id){
		List<StageExamUserQuestionVo> list = service.getUserQuestionAnswer(stage_grade_id);
		Stage_Exam stageExam = service.getStageExamByStageExamId(stage_exam_id);
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stage_exam_result");
		mav.getModel().put("StageExamUserQuestion", list);
		mav.getModel().put("stageExam", stageExam);
		return mav;
		
	} 
	
}
