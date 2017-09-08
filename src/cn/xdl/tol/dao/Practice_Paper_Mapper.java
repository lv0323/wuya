package cn.xdl.tol.dao;
import java.util.List;
import cn.xdl.tol.bean.Knowlege;
import cn.xdl.tol.bean.Practice_Question;
import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.User;
import cn.xdl.tol.params.InsertPracticePO;
import cn.xdl.tol.params.Practice_PaperPO;
import cn.xdl.tol.vo.Practice_Max_User_VO;

/**
 * 刷题试卷DAO接口
 * @author Zs
 */
public interface Practice_Paper_Mapper {
	/**
	 * 通过用户刷题的选择获取要刷的题目
	 * @param practice_PaperPO 用户刷题的选择参数
	 * @return 返回符合用户选择的试题集合
	 */
	List<Question> findPracticePaper(Practice_PaperPO practice_PaperPO);
	/**
	 * 通过学科id和阶段id查询对应知识点
	 * @param subject_id 学科id
	 * @param stage_id 阶段id
	 * @return 返回知识点的集合
	 */
	List<Knowlege> findKnowlegeBySubject_idAndStage_id(Integer subject_id, Integer stage_id);
	/**
	 * 通过学科id查询题目涉及的难度
	 * @param subject_id 学科id
	 * @return 难度的集合
	 */
	List<String> findAllEasy_TypeBySubject_id(Integer subject_id);
	
	/**
	 * 通过学科id查询学科对象
	 * @param subject_id 要查询的学科id
	 * @return 返回对应的学科
	 */
	Subject findSubjectById(Integer subject_id);
	/**
	 * 根据学科id查询所有该学科知识点
	 * @param subject_id 学科id
	 * @return 该学科下所有知识点集合
	 */
	List<Knowlege> findAllKnowledgeBySubject_id(Integer subject_id);
	/**
	 * 返回所有试题中包含的学科id
	 * @return 返回学科id的集合
	 */
	List<Integer> findSubjectIdFromQuestion();
	/**
	 * 通过用户选择的vo对象查出刷题试卷的总分数
	 * @param practice_PaperPO 用户选择的vo对象
	 * @return 返回符合用户选择刷题的总分数
	 */
	Integer findPracticePaperScore(Practice_PaperPO practice_PaperPO);
	/**
	 * 查询刷题最多前三名用户
	 * @return 刷题最多用户id和刷题数的vo对象集合
	 */
	List<Practice_Max_User_VO> findMaxPracticeUser();
	/**
	 * 通过用户id查询最新一次刷题id
	 * @param user_id 要查询的uer_id
	 * @return 最新一次刷题id
	 */
	Integer findLastPracticeByUser_Id(Integer user_id);
	/**
	 * 根据用户刷题结果插入刷题表
	 * @param po 刷题vo对象
	 */
	void insertPractice(InsertPracticePO po);
	/**
	 * 通过试题id查找试题
	 * @param question_id 要查找的试题id
	 * @return 返回要查找的试题
	 */
	Question findQuestionById(Integer question_id);
	
	/**
	 * 通过用户刷题答案对象插入用户刷题答案表
	 * @param practice_Question 用户刷题答案表对象
	 */
	void insertPractice_Question(Practice_Question practice_Question);
	/**
	 * 通过知识点id查询知识点名称
	 * @param knowlege_id 要查找的知识点id
	 * @return 查找的知识点名称
	 */
	String findKnowlege_NameById(Integer knowlege_id);
	/**
	 * 根据用户id查找用户
	 * @param user_id 要查找的用户id
	 * @return 返回查找的用户
	 */
	User findUserById(Integer user_id);
}
