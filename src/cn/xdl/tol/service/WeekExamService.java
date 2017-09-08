package cn.xdl.tol.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.User;
import cn.xdl.tol.bean.Week_Answer;
import cn.xdl.tol.bean.Week_Exam;
import cn.xdl.tol.bean.Week_Grade;
import cn.xdl.tol.bean.Weekly_Type;
import cn.xdl.tol.dao.WeekExamMapper;
import cn.xdl.tol.vo.WeekExamKnowlegeVo;
import cn.xdl.tol.vo.WeekExamQuestionUserVo;

/**
 * 
 * @author Qin
 *
 */
@Component
public class WeekExamService {
	
	@Resource
	private WeekExamMapper mapper;
	
	/**
	 * 根据周id查询对应的试卷
	 * @param weekly_type_id 周类型的id
	 * @return 包含对应周类型id的试卷集合
	 */
	public List<Week_Exam> findWeekExamId(int weekly_type_id){
		List<Week_Exam> list = mapper.findWeekExamId(weekly_type_id);
		return list;
	}
	
	/**
	 * 根据周测试卷id查询对应的周测试卷信息
	 * @param week_exam_id 周测试卷id
	 * @return 周测试卷对象
	 */
	public Week_Exam findWeekExam(int week_exam_id){
		Week_Exam weekExam = mapper.findWeekExam(week_exam_id);
		return weekExam;
	}
	
	/**
	 * 根据试卷编号查询改试卷的试题
	 * @param week_exam_id 试卷编号
	 * @return 存有试卷编号对应试题的集合
	 */
	public List<Question> findWeekQuestion(int week_exam_id){
		List<Question> list = mapper.findWeekExamQuestion(week_exam_id);
		return list;
	}
	
	/**
	 * 根据对应的周信息查询相关的周测试卷id
	 * 随机从现有的周试卷id中抽出1套试卷并获取其中包含的试题
	 * @param weekly_type_id 周信息id
	 * @return 包含有周测试卷试题的集合
	 */
	public Map<String,Object> findWeekExamQuestion(int weekly_type_id){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Week_Exam> exam = mapper.findWeekExamId(weekly_type_id);
		//System.out.println(exam.size());
		int[] we = new int[exam.size()];
		for(int i = 0;i<exam.size();i++){
			we[i]=exam.get(i).getWeek_exam_id();
		}
		Random ra = new Random();
		int index = ra.nextInt(exam.size());
		int week_exam_id = we[index];
		Week_Exam weekExam = mapper.findWeekExam(week_exam_id);
		List<Question> weekExamQuestion = mapper.findWeekExamQuestion(week_exam_id);
		map.put("weekExam", weekExam);
		map.put("weekExamQuestion", weekExamQuestion);
		return map;
	}
	
	/**
	 * 查询所有学科
	 * @return 返回包含所有学科的集合
	 */
	public List<Subject> findAllSubject(){
		List<Subject> subject = mapper.findAllSubject();
		return subject;
	}

	/**
	 * 根据学科查找对应的周信息
	 * @param subject_id 学科id
	 * @return 存有学科id对应的周信息的集合
	 */
	public List<Weekly_Type> findWeek(int subject_id) {
		List<Weekly_Type> week = mapper.findWeeklyType(subject_id);
		return week;
	}
	
	/**
	 * 向成绩表里插入考试信息
	 * @param wr 成绩表对象
	 */
	public void insertWeekGrade(Week_Grade wr){
		mapper.insertWeekGrade(wr);
	}
	
	/**
	 * 
	 * 根据成绩表对象信息查询对应的成绩表对象
	 * @param wr 成绩表对象(不包含成绩表id)
	 * @return 成绩表对象(包含成绩表id)
	 */
	public Week_Grade findWeekGrade(Week_Grade wr){
		Week_Grade wg = mapper.findWeekGrade(wr);
		return wg;
	}
	
	/**
	 * 向周测答案表里添加数据
	 * @param wa 用户周测答案信息对象
	 */
	public void insertWeekAnswer(Week_Answer wa){
		mapper.insertWeekAnswer(wa);
	}
	
	/**
	 * 向周测成绩表插入周测成绩
	 * @param wr 周测成绩对象
	 */
	public void updateGradeToWeek(Week_Grade wr){
		mapper.updateGradeToWeek(wr);
	}
	
	/**
	 * 查询单个用户的方法
	 * @param id 要查询的用户ID
	 * @return 返回查询的结果
	 */
	public User findUserById(int id){
		User user = mapper.findUserById(id);
		return user;
	} 
	
	
	/**
	 * 根据用户周测成绩表id查找答对的试题对应的知识点名字和数量以及涉及的知识点名字和每个知识点的数量
	 * @param week_grade_id 用户周测成绩表id
	 * @return 试卷涉及的知识点信息
	 */
	public List<WeekExamKnowlegeVo> findWeekExamKnowlege(int week_exam_id,int week_grade_id){
		List<WeekExamKnowlegeVo> list = mapper.findWeekExamKnowlege(week_exam_id);
		List<WeekExamKnowlegeVo> list1 = mapper.findRihgtWeekExamKnowlege(week_grade_id);
		List<WeekExamKnowlegeVo> list2 = mapper.findRihgtWeekExamKnowlegeGrade(week_grade_id);
		
		for (WeekExamKnowlegeVo w1 : list) {
			for(WeekExamKnowlegeVo w2 : list1) {
				if(w1.getKnowlege_id()==w2.getKnowlege_id()){
					w1.setRightCount(w2.getCount());
				}
			}
			for(WeekExamKnowlegeVo w3 : list2){
				if(w1.getKnowlege_id()==w3.getKnowlege_id()){
					w1.setRightGrade(w3.getGrade());
				}
			}
		}
		return list;
	}
	
	/**
	 * 根据周测成绩表id查询考试包含的试题以及用户的答案
	 * @param week_grade_id 周测成绩表id
	 * @return 包含用户选项的试题信息
	 */
	public List<WeekExamQuestionUserVo> findQuestionUserAnswer(int week_grade_id){
		List<WeekExamQuestionUserVo> list = mapper.findQuestionUserAnswer(week_grade_id);
		return list;
	}
}
