package cn.xdl.tol.dao;

import java.util.List;

import cn.xdl.tol.po.SelectStageExamPo;
import cn.xdl.tol.vo.Not_In_Week_Exam_Question_Vo;
import cn.xdl.tol.vo.Stage_Exam_List_Vo;
import cn.xdl.tol.vo.Stage_Exam_Message_vo;
import cn.xdl.tol.vo.Stage_Exam_Question_List_vo;

public interface StageMapper {
	
	public List<String> findStageNameBySubject_Name(String name);
	
	public List<Stage_Exam_List_Vo> findStageExamMessage(SelectStageExamPo o);
	
	public void deleteStageExam(int id);
	
	/**
	 * 通过试卷编号获取试卷所有试题信息
	 * @param id 试卷编号
	 * @return
	 */
	public List<Stage_Exam_Question_List_vo> findStageExamQuestion(int id);
	
	/**
	 * 通过试卷编号搜索试卷信息
	 * @param id 试卷编号
	 * @return 试卷信息对象
	 */
	public Stage_Exam_Message_vo findStageExamMessageByExamId(int id);
	/**
	 * 通过试卷编号计算试卷试题总成绩
	 * @param id 试卷编号
	 * @return 试卷总成绩
	 */
	public int sumDetailsScore(int id);
	/**
	 * 通过试卷编号修改试卷总成绩
	 * @param id 试卷编号
	 * @param score 新的试卷总成绩
	 */
	public void updateExamScore(int id,double score);
	/**
	 * 通过试卷编号和试题编号删除周测试卷内对应的试题
	 * @param examId 试卷编号
	 * @param questionId 试题编号
	 */
	public void deleteExamQuestionByExamIdAndQuestionId(int examId,int questionId);
	/**
	 * 通过试卷id、学科、编号查询题库中不在此试卷中的题目
	 * @param id 试卷编号
	 * @param subject 学科名
	 * @param week 周名
	 * @return 试题信息集合
	 */
	public List<Not_In_Week_Exam_Question_Vo> findNotInStageExamQuestionMessageByQuestionIdAndSubjectNameStageName(int id,String subject,String week);
	/**
	 * 通过学科名和周名查询此周内包含的所有知识点
	 * @param subject 学科名
	 * @param week 周名
	 * @return 知识点名的集合
	 */
	public List<String> findKnowlegeNameBySubjectNameAndStageName(String subject,String week);
	/**
	 * 通过试卷编号查询周名
	 * @param id 试卷编号
	 * @return 周名
	 */
	public String findStageNameByStageExamId(int id);
	
	public void insertStageExamQuestion(int weekId,int questionId);
	
	public void updateStageExamDisplay(int id,int status);
	
}
