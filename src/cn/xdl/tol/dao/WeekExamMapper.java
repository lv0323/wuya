package cn.xdl.tol.dao;

import java.util.List;

import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.User;
import cn.xdl.tol.bean.Week_Answer;
import cn.xdl.tol.bean.Week_Exam;
import cn.xdl.tol.bean.Week_Grade;
import cn.xdl.tol.bean.Weekly_Type;
import cn.xdl.tol.vo.WeekExamKnowlegeVo;
import cn.xdl.tol.vo.WeekExamQuestionUserVo;
/**
 * 
 * @author Qin
 *
 */

public interface WeekExamMapper {
	/**
	 * 查询所有学科
	 * @return 包含所有学科的集合
	 */
	public List<Subject> findAllSubject();
	
	/**
	 * 根据学科id查询对应的周信息
	 * @param subject_id 学科id
	 * @return 存有周信息的集合
	 */
	public List<Weekly_Type> findWeeklyType(int subject_id);
	
	/**
	 * 根据对应的周信息查询相关的周测试卷id
	 * @param weekly_type_id 周信息id
	 * @return 包含有周测试卷信息的集合
	 */
	public List<Week_Exam> findWeekExamId(int weekly_type_id);
	
	/**
	 * 查询对应学科的对应周测试卷中的试题
	 * @param week_exam_id 周测试卷id
	 * @return 存有所有周测试题的集合
	 */
	public List<Question> findWeekExamQuestion(int week_exam_id);
	
	/**
	 * 根据周测试卷id查询对应的周测试卷信息
	 * @param week_exam_id 周测试卷id
	 * @return 周测试卷对象
	 */
	public Week_Exam findWeekExam(int week_exam_id);
	
	/**
	 * 向成绩表里插入成绩信息
	 * @param wr 成绩表对象
	 */
	public void insertWeekGrade(Week_Grade wr);
	
	/**
	 * 根据成绩表对象信息查询对应的成绩表对象
	 * @param wr 成绩表对象(不包含成绩表id)
	 * @return 成绩表对象(包含成绩表id)
	 */
	public Week_Grade findWeekGrade(Week_Grade wr);
	
	/**
	 * 向周测答案表里添加数据
	 * @param wa 用户周测答案对象
	 */
	public void insertWeekAnswer(Week_Answer wa);
	
	/**
	 * 向周测成绩表插入周测成绩
	 * @param wr 周测成绩对象
	 */
	public void updateGradeToWeek(Week_Grade wr);
	
	/**
	 * 查询单个用户的方法
	 * @param id 要查询的用户ID
	 * @return 返回查询的结果
	 */
	public User findUserById(int id);
	
	/**
	 * 根据试卷id查询该试卷中涉及的知识点名字和每个知识点的数量
	 * @param week_exam_id 试卷id
	 * @return 该试卷涉及的知识点信息
	 */
	public List<WeekExamKnowlegeVo> findWeekExamKnowlege(int week_exam_id);

	/**
	 * 根据用户周测成绩表id查找答对的试题对应的知识点名字和数量
	 * @param week_grade_id 用户周测成绩表id
	 * @return 用户答对的知识点信息
	 */
	public List<WeekExamKnowlegeVo> findRihgtWeekExamKnowlege(int week_grade_id);
	
	/**
	 * 根据用户周测成绩表id查找答对的知识点对应的分数
	 * @param week_grade_id 周测成绩表id
	 * @return 用户答对的知识点信息
	 */
	public List<WeekExamKnowlegeVo> findRihgtWeekExamKnowlegeGrade(int week_grade_id);
	
	/**
	 * 根据周测成绩表id查询考试包含的试题以及用户的答案
	 * @param week_grade_id 周测成绩表id
	 * @return 包含用户选项的试题信息
	 */
	public List<WeekExamQuestionUserVo> findQuestionUserAnswer(int week_grade_id);
}

