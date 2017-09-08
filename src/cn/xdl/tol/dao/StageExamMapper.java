package cn.xdl.tol.dao;

import java.sql.Timestamp;

import java.util.List;

import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Stage;
import cn.xdl.tol.bean.Stage_Answer;
import cn.xdl.tol.bean.Stage_Exam;
import cn.xdl.tol.bean.Stage_Grade;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.User;
import cn.xdl.tol.vo.StageExamKnowlegeVo;
import cn.xdl.tol.vo.StageExamUserQuestionVo;

public interface StageExamMapper {
	/**
	 * 
	 * 查询学科表
	 * @return 学科集合
	 */
	public List<Subject> findAllSubject();
	/**
	 * 
	 * 通过学科id获得阶段集合对象
	 * @param subject_id 学科id
	 * @return 阶段集合
	 */
	public List<Stage> getStageBySubjectId(Integer subject_id);
	/**
	 * 通过阶段id获得阶段测试卷表对象
	 * @param stage_id 阶段id
	 * @return 阶段测试卷表集合
	 */
	public List<Stage_Exam> getStageExamById(int stage_id);
	/**
	 * 通过查询阶段测试卷表，获得阶段测试卷的试题
	 * @param stage_exam_id 阶段测试卷表的id
	 * @return 对应阶段测试卷的试题集合
	 */
	public List<Question> getQuestionListById(int stage_exam_id);
	/**
	 * 通过阶段测试卷id查询那张试卷的信息
	 * @param stage_exam_id 阶段测试卷编号id
	 * @return 返回阶段测试卷信息
	 */
	public Stage_Exam getStageExamDetailsById(int stage_exam_id);
	/**
	 * 插入阶段成绩表
	 * @param user_id 用户编号
	 * @param stage_exam_id 阶段试卷编号
	 * @param subject_id 学科编号
	 * @param time 时间
	 */
	public void insertIntoStageGrade(Stage_Grade stage_grade);
	/**
	 * 查询自动增加完编号的阶段成绩表
	 * @param user_id 用户编号
	 * @param time 时间
	 * @return
	 */
	public Stage_Grade findFromStageGrade(Stage_Grade stage_grade);
	/**
	 *插入答案表
	 * @param stageAnswer 答案对象
	 */
	public void insertIntoStageAnswer(Stage_Answer stageAnswer);
	/**
	 * 查询阶段成绩表
	 * @param stage_exam_id 阶段测试卷编号
	 * @return 自动增加编号之后的阶段成绩表（获得成绩还没有插入）
	 */
	public Stage_Grade findAllFromStageGrade(int stage_exam_id);
	/**
	 * 将总分更新到试卷成绩表后面
	 * @param grade  总成绩
	 * @param stage_grade_id 阶段试卷成绩表编号
	 */
	public void updateScore(Stage_Grade stage_grade);
	/**
	 * 通过用户编号查找用户表
	 * @param user_id 用户编号
	 * @return 用户对象
	 */
	public User getUserByUserId(int user_id);
	/**
	 * 查询阶段试卷表
	 * @param stage_exam_id 阶段试卷编号
	 * @return 阶段试卷对象
	 */
	public Stage_Exam getStageExamByStageExamId(int stage_exam_id);
	/**
	 * 获得分析列表所有知识点的名字和数量
	 * @param stage_exam_id  阶段试卷编号
	 * @return 视图对象集合
	 */
	public List<StageExamKnowlegeVo> getAllKnowlegeNameAndCount(int stage_exam_id);
	/**
	 * 获得正确知识点名字和数量
	 * @param stage_grade_id 阶段成绩表编号
	 * @return 视图对象集合
	 */
	public List<StageExamKnowlegeVo> getRightKnowlegeNameAndCount(int stage_grade_id);
	/**
	 * 获得正确知识点的编号和正确的分数
	 * @param stage_grade_id 阶段成绩表编号
	 * @return 视图对象集合
	 */
	public List<StageExamKnowlegeVo> getRightKnowlegeIdAndRightGrade(int stage_grade_id);
	/**
	 * 获得视图对象表
	 * @param stage_grade_id 阶段成绩编号
	 * @return 查看答案视图表
	 */
	public List<StageExamUserQuestionVo> getUserQuestionAnswer(int stage_grade_id);
}

