package cn.xdl.tol.dao;

import java.util.List;

import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.Weekly_Type;
import cn.xdl.tol.po.SelectWeekExamPo;
import cn.xdl.tol.vo.Not_In_Week_Exam_Question_Vo;
import cn.xdl.tol.vo.Week_Exam_List_Vo;
import cn.xdl.tol.vo.Week_Exam_Message_vo;
import cn.xdl.tol.vo.Week_Exam_Question_List_vo;

public interface Weekly_TypeMapper {
	/**
	 * 通过上传周名查询对应的ID
	 * @param name 周名
	 * @return 对应周名的ID
	 */
	public int findWeekIdByName(String name);
	/**
	 * 搜索所有学科
	 * @return 所有学科对象的集合
	 */
	public List<Subject> findAllSubject();
	/**
	 * 通过学科名字查询该学科下包含的<br><br>
	 * 所有周的对象集合
	 * @param name 学科名
	 * @return 周对象集合
	 */
	public List<Weekly_Type> findWeekly_TypeBySubject_Name(String name);
	/**
	 * 查询试题信息
	 * @param s 参数对象
	 * @return 试题信息集合
	 */
	public List<Week_Exam_List_Vo> findWeekExamMessage(SelectWeekExamPo s);
	/**
	 * 通过试卷编号删除试卷
	 * @param id 试卷编号
	 * 
	 */
	public void deleteWeekExam(int id);
	/**
	 * 通过试卷编号获取试卷所有试题信息
	 * @param id 试卷编号
	 * @return
	 */
	public List<Week_Exam_Question_List_vo> findWeekExamQuestion(int id);
	/**
	 * 通过试卷编号搜索试卷信息
	 * @param id 试卷编号
	 * @return 试卷信息对象
	 */
	public Week_Exam_Message_vo findWeekExamMessageByExamId(int id);
	/**
	 * 通过试卷编号计算试卷试题总成绩
	 * @param id 试卷编号
	 * @return 试卷总成绩
	 */
	public int sumDetailsScore(int id);
	/**
	 * 通过试卷编号和试题编号删除周测试卷内对应的试题
	 * @param examId 试卷编号
	 * @param questionId 试题编号
	 */
	public void deleteExamQuestionByExamIdAndQuestionId(int examId,int questionId);
	/**
	 * 通过试卷编号修改试卷总成绩
	 * @param id 试卷编号
	 * @param score 新的试卷总成绩
	 */
	public void updateExamScore(int id,double score);
	/**
	 * 通过试卷id、学科、编号查询题库中不在此试卷中的题目
	 * @param id 试卷编号
	 * @param subject 学科名
	 * @param week 周名
	 * @return 试题信息集合
	 */
	public List<Not_In_Week_Exam_Question_Vo> findNotInWeekExamQuestionMessageByQuestionIdAndSubjectNameWeekName(int id,String subject,String week);
	/**
	 * 通过学科名和周名查询此周内包含的所有知识点
	 * @param subject 学科名
	 * @param week 周名
	 * @return 知识点名的集合
	 */
	public List<String> findKnowlegeNameBySubjectNameAndWeekName(String subject,String week);
	/**
	 * 通过试卷编号查询周名
	 * @param id 试卷编号
	 * @return 周名
	 */
	public String findWeekNameByWeekExamId(int id);
	
	public void insertWeekExamQuestion(int weekId,int questionId);
	public void updateWeekExamDisplay(int id,int status);
}
