package cn.xdl.tol.dao;

import java.util.List;

import cn.xdl.tol.bean.Knowlege;
import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.QuestionAndSubjectAndKnowlege;
import cn.xdl.tol.bean.QuestionParam;
import cn.xdl.tol.bean.Stage;
import cn.xdl.tol.bean.Stage_Exam;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.User;
import cn.xdl.tol.bean.Week_Exam;
import cn.xdl.tol.bean.Weekly_Type;

/**
 * 
 * @author zhangjing
 *
 */
public interface QuestionMapper {
	/**
	 * 查询所有试题,包括知识点id和学科id
	 * 
	 * @return List<Question>试题集合
	 */
	public List<Question> findAllQuestion();

	/**
	 * 插入试题
	 * 
	 * @param q
	 *            Question对象
	 * @return int类型，影响几行数据
	 */
	public int insertQuestion(Question q);

	/**
	 * 根据学科id和知识点id查询试题
	 * 
	 * @param subject_id
	 *            学科id
	 * @param knowlege_id
	 *            知识点id
	 * @return List<Question>试题集合
	 */
	public List<Question> findQuestionBySubjectAndKnowlege(int subject_id, int knowlege_id);

	/**
	 * 根据学科名查询学科id
	 * 
	 * @param subject_name学科名
	 * @return subject对象
	 */
	public Subject findSubjectIdBySubjectname(String subject_name);

	/**
	 * 根据知识点名查询知识点id
	 * 
	 * @param knowlege_name
	 *            知识点名
	 * @return Knowlege 对象
	 */
	public Knowlege findKnowlegeIdByKnowlegename(String knowlege_name);

	/**
	 * 查询所有试题,包括知识点名和学科名
	 * 
	 * @param subject_id
	 *            学科id
	 * @param knowlege_id
	 *            知识点id
	 * @return List<QuestionAndSubjectAndKnowlege>试题集合
	 */
	public List<QuestionAndSubjectAndKnowlege> findallQuestion(int subject_id, int knowlege_id);

	/**
	 * 查询所有试题,包括知识点名和学科名
	 * 
	 * @param qp
	 *            QuestionParam请求参数对象，
	 * @return List<QuestionAndSubjectAndKnowlege>试题集合
	 */
	public List<QuestionAndSubjectAndKnowlege> findallQuestionByallchoose(QuestionParam qp);

	/**
	 * 根据题号查询试题,包括知识点名和学科名
	 * 
	 * @param question_id
	 *            试题id
	 * @return List<QuestionAndSubjectAndKnowlege>试题集合
	 */
	public List<QuestionAndSubjectAndKnowlege> findQuestionById(int question_id);

	/**
	 * 根据题名模糊查询试题,包括知识点名和学科名
	 * 
	 * @param question_name
	 *            试题名
	 * @return List<QuestionAndSubjectAndKnowlege>试题集合
	 */
	public List<QuestionAndSubjectAndKnowlege> findQuestionByName(String question_name);

	/**
	 * 根据题号删除一道试题，将其删除状态改为1表已删除
	 * 
	 * @param question_id
	 *            试题id
	 * @return 影响行数
	 */
	public int removeQuestionById(int question_id);
	/**
	 * 根据题号查询试题所有信息,包括知识点名和学科名
	 * 
	 * @param question_id
	 *            试题id
	 * @return List<QuestionAndSubjectAndKnowlege>试题集合
	 */
	public List<QuestionAndSubjectAndKnowlege>	findQuestionAllById(int question_id);
	/**
	 * 根据题号更改一道试题
	 * @param question_id 试题id
	 * @param easy_type 难易程度
	 * @param question_name  试题名
	 * @param score 成绩
	 * @param option_A A选项
	 * @param option_D A选项
	 * @param answer  答案
	 * @param option_B B选项
	 * @param option_C C选项
	 * @return 影响行数
	 */
	public int updateQuestionById(String easy_type, String question_name, String score,
			String option_A, String option_D, String answer, String option_B, String option_C, int question_id);
	
	/**
	 * 根据知识点Id获取阶段Id和周号id
	 * @param knowlege_id 知识点id
	 * @return Knowlege
	 */
	public Knowlege	findStageAndWeekId(int knowlege_id);

	/**
	 * 根据周类型名和学科ID获取周号id
	 * @param weekly_type_name 周类型名
	 * @param int subject_id 学科id
	 * @return Weekly_Type
	 */
	public Weekly_Type	findWeekTypeByWeekName(String weekly_type_name,int subject_id);
	/**
	 * 根据阶段名获取阶段号id
	 * @param stage_name 阶段类型名
	 * @return Weekly_Type
	 */
	public Stage	findStageIdByStageName(String stage_name);
	/**
	 * 根据阶段id和学科id查询对应试题
	 * @param stage_type_id 阶段类型id
	 * @param int subject_id学科id
	 * @return List<QuestionAndSubjectAndKnowlege> 试题集合
	 */
	public List<QuestionAndSubjectAndKnowlege>	findallQuestionWithStage(int stage_id,int subject_id);
	/**
	 * 根据周号id和学科id查询对应试题
	 * @param weekly_type_id 周测类型id
	 * @param int subject_id学科id
	 * @return List<QuestionAndSubjectAndKnowlege> 试题集合
	 */
	public List<QuestionAndSubjectAndKnowlege>	findallQuestionWithWeek(int weekly_type_id,int subject_id);
	/**
	 *	
	 * 添加一阶段测段试题
	 * @param stage_exam_name  阶段类型试卷名称
	 * @param stage_id  第几阶段id
	 * @return
	 */
	public int addStageExam(String stage_exam_name,int stage_id);
	/**
	 * 添加一周测段试题
	 * @param week_exam_id  第几周类型id
	 * @param week_exam_name  周类型试卷名称
	 * @return 影响行数
	 */
	public int addWeekExam(int week_exam_id,String week_exam_name);
	/**
	 * 根据阶段试题名查询试卷id
	 * @param stage_exam_name  阶段类型试卷名称
	 * @return Stage_Exam对象
	 */
	public Stage_Exam findStageIdByName(String stage_exam_name);
	/**
	 * 根据周试题名查询试卷id
	 * @param week_exam_name  周类型试卷名称
	 * @return Week_Exam 对象
	 */
	public Week_Exam findWeekIdByName(String week_exam_name);
	/**
	 * 根据阶段试卷编号 向阶段细节表 中插入一道试题Id
	 * @param question_id	问题id
	 * @param stage_exam_id  阶段试卷编号
	 * @return
	 */
	public int addStageExamDetail(int question_id,int stage_exam_id);
	
	/**
	 * 根据周试卷编号 向周测细节表 中插入一道试题Id
	 * @param question_id	问题id
	 * @param stage_exam_id  阶段试卷编号
	 * @return
	 */
	public int addWeekExamDetail(int question_id,int week_exam_id);
	
}
