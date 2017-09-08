package cn.xdl.tol.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.User;
import cn.xdl.tol.bean.Week_Answer;
import cn.xdl.tol.bean.Week_Exam;
import cn.xdl.tol.bean.Week_Grade;
import cn.xdl.tol.bean.Weekly_Type;
import cn.xdl.tol.service.WeekExamService;
import cn.xdl.tol.vo.WeekExamKnowlegeVo;
import cn.xdl.tol.vo.WeekExamQuestionUserVo;

@Controller
@Transactional
public class WeekExamController {
	
	@Resource
	private WeekExamService wes;
	
	@RequestMapping("/find_week_exam.do")
	@ResponseBody
	public String findWeekExam(int weekly_type_id){
		List<Week_Exam> list = wes.findWeekExamId(weekly_type_id);
		String json=null;
		if(list.size()==0){
			json = "{\"error\":0}";
		}else{
			json = "{\"error\":1}";
		}
		return json;
	}
	
	@RequestMapping("/week_exam.do")
	public ModelAndView findWeekExamQuestion(int weekly_type_id){
		Map<String, Object> map = wes.findWeekExamQuestion(weekly_type_id);
		ModelAndView mav = new ModelAndView();
		Week_Exam we = (Week_Exam)map.get("weekExam");
		List<Question> list = (List)map.get("weekExamQuestion");
		mav.setViewName("week_exam");
		mav.getModel().put("Questions", list);
		mav.getModel().put("weekExam", we);
		return mav;
		
	}
	
	@RequestMapping("/subject_list.do")
	public ModelAndView findAllSubject(){
		List<Subject> subject = wes.findAllSubject();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("choose_w_exam");
		mav.getModel().put("subject", subject);
		return mav;
	}
	
	@RequestMapping("/week_list.do")
	@ResponseBody
	public List<Weekly_Type> findWeek(int subject_id,HttpServletRequest request){
		List<Weekly_Type> week = wes.findWeek(subject_id);
		request.getSession().setAttribute("qsubject_id", subject_id);
		return week;
	}
	
	@RequestMapping("/week_exam_grade.do")
	public ModelAndView getWeekExamGrade(HttpServletRequest request){
		double grade = 0.0;
		//根据用户答题信息向成绩表插入数据，此时成绩表id以及成绩都没有，插入数据后生成成绩表id
		request.getSession().setAttribute("userId", 1);
		int userId = (int)request.getSession().getAttribute("userId");
		int week_exam_id =(int)request.getSession().getAttribute("qweek_exam_id");
		int subject_id = (int)request.getSession().getAttribute("qsubject_id");
		Timestamp tt = new Timestamp(System.currentTimeMillis());
		Week_Grade wg = new Week_Grade();
		wg.setUser_id(userId);
		wg.setWeek_exam_id(week_exam_id);
		wg.setSubject_id(subject_id);
		wg.setTime(tt);
		wes.insertWeekGrade(wg);
		//根据之前插入的数据查询生成的成绩表id
		Week_Grade nwg = wes.findWeekGrade(wg);
		
		List<Question> question = wes.findWeekQuestion(week_exam_id);
		//遍历该试卷对应的试题进行判分，并将用户答案以及结果存入用户答案表
		for (Question question2 : question) {
			String user_answer = request.getParameter(question2.getQuestion_id()+"");
			if(question2.getAnswer().equalsIgnoreCase(user_answer)){
				grade += question2.getScore();
				Week_Answer wa = new Week_Answer();
				wa.setWeek_grade_id(nwg.getWeek_grade_id());
				wa.setQuestion_id(question2.getQuestion_id());
				wa.setUser_answer(user_answer);
				wa.setIs_right(1);
				wes.insertWeekAnswer(wa);
			}else{
				Week_Answer wa = new Week_Answer();
				wa.setWeek_grade_id(nwg.getWeek_grade_id());
				wa.setQuestion_id(question2.getQuestion_id());
				wa.setUser_answer(user_answer);
				wa.setIs_right(0);
				wes.insertWeekAnswer(wa);
			}
		}
		ModelAndView mav = new ModelAndView();
		//根据试卷id查询该试卷涉及的知识点信息
		List<WeekExamKnowlegeVo> weekExamKnowlege = wes.findWeekExamKnowlege(week_exam_id,nwg.getWeek_grade_id());
		mav.getModel().put("weekExamKnowlege", weekExamKnowlege);
		
		//根据算出来的成绩将成绩更新至周测成绩表
		Week_Grade wgg = new Week_Grade();
		wgg.setWeek_grade_id(nwg.getWeek_grade_id());
		wgg.setGrade(grade);
		wes.updateGradeToWeek(wgg);
		
		mav.setViewName("week_report");
		mav.getModel().put("grade", grade);
		mav.getModel().put("week_grade_id", nwg.getWeek_grade_id());
		User user = wes.findUserById(userId);
		mav.getModel().put("user", user);
		Week_Exam weekExam = wes.findWeekExam(week_exam_id);
		mav.getModel().put("week_exam_message", weekExam);
		int rank =0;     //定义用户等级
		double newGrade= grade*100/weekExam.getTatal_points();  //百分制得分
		String evaluate = null;
		String analysis = null;
		if(newGrade<=60){
			rank=4;
			evaluate = "这说明你对本学科现阶段所要求知识点的掌握不够扎实，这导致你缺乏运用所学知识独立"
					 + "分析并解决问题的能力，答题的正确率很低。你的解题技巧有待全面提高，知识点线"
					 + "索需梳理清楚，学科基础知识架构亟需完善。";
			analysis = "本次测试相对客观地反映出你在学习中存在非常严重的问题：基础薄弱、很难将所学知识"
					+ "应用于解题中、缺乏必要的应试技巧……不得不说，你已经落后于现阶段要求达到的学科掌握"
					+ "平均水平。然而，这种处境并不可怕，可怕的是自此失去信心和勇气。所以接下来，你需要拿"
					+ "出\"置之死地而后生\"的魄力，认真思考怎样改变现状，怎样突破困境，如何有效地开展你的学"
					+ "习，尽快走出学习的低谷。";
		}else if(newGrade<=70){
			rank=3;
			evaluate ="这说明你对本学科现阶段所要求知识点的掌握不够扎实，运用所学知识独立分析并解决问题"
					 + "的能力比较薄弱，答题的正确率较不理想。解题技巧需要努力提高，知识点线索梳理的不够"
					 + "全面，学科基础知识架构亦有待完善。";
			analysis = "本次测试相对客观地反映出你在学习中存在的问题：基础不够扎实、将所学知识"
					+ "应用于解题中、必要的应试技巧不太成熟，但你基本掌握现阶段要求达到的学科知识"
					+ "平均水平。然而，你的知识结构不牢固，仍需要下苦功夫。所以接下来，你需要拿"
					+ "出\"置之死地而后生\"的魄力，认真思考怎样改变现状，怎样突破困境，如何有效地开展你的学"
					+ "习，尽快掌握现阶段应该掌握的知识内容。";
		}else if(newGrade<=80){
			rank=2;
			evaluate ="这说明你对本学科现阶段所要求知识点的掌握不是特别扎实，运用所学知识独立分析并解决问"
					 + "题的能力还需加强，答题的正确率不够高。你的解题技巧还需提高，知识点线索梳理的不是"
					 + "很透彻，学科基础知识架构还需更加完善。";
			analysis = "本次测试相对客观地反映出你在学习中存在的部分问题：基础牢固、但将所学知识"
					+ "应用于解题中的能力还不够、必要的应试技巧已经有了，但不完善……不得不说，你已达到现阶段要求达到的学科掌握"
					+ "平均水平。然而，这种处境并不乐观，可怕的是你的骄傲自满。所以接下来，你需要拿"
					+ "出再接再厉的魄力，认真思考怎样提升自己，如何有效地开展你的学"
					+ "习，尽快取得优异的成绩。";
		}else if(newGrade<=100){
			rank=1;
			evaluate ="这说明你对本学科现阶段所要求知识点的掌握比较扎实，已经可以运用所学知识独立分析并解决"
					 + "问题，答题的正确率很理想。你的解题技巧非常完善，知识点线索梳理的很清楚，学科基础知识"
					 + "架构已经基本完善。";
			analysis = "本次测试相对客观地反映出你在学习中存在优势：基础牢固、灵活的将所学知识"
					+ "应用于解题中、拥有必要的应试技巧……不得不说，你已达到现阶段要求达到的学科掌握"
					+ "平均水平。然而，这种状态不要过于乐观，可怕的是你骄傲自满。所以接下来，你需要拿"
					+ "出之前的学习状态和魄力，认真思考接下来如何有效地开展你的学"
					+ "习，再次取得优异成绩。";
		}
		mav.getModel().put("evaluate", evaluate);
		mav.getModel().put("analysis", analysis);
		mav.getModel().put("rank", rank);
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
		String str = format.format(tt);
		mav.getModel().put("week_exam_time", str);
		
		return mav;
		
	}
	
	@RequestMapping("/week_exam_result.do")
	public ModelAndView findQuestionUserAnswer(int week_exam_id,int week_grade_id){
		List<WeekExamQuestionUserVo> list = wes.findQuestionUserAnswer(week_grade_id);
		Week_Exam weekExam = wes.findWeekExam(week_exam_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("week_exam_result");
		mav.getModel().put("user_answer", list);
		mav.getModel().put("weekExam", weekExam);
		return mav;
	}
}
