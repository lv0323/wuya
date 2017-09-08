package cn.xdl.tol.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import cn.xdl.tol.bean.Knowlege;
import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.QuestionAndSubjectAndKnowlege;
import cn.xdl.tol.bean.QuestionParam;
import cn.xdl.tol.bean.Stage;
import cn.xdl.tol.bean.Stage_Exam;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.Weekly_Type;
import cn.xdl.tol.dao.QuestionMapper;

/**
 * 问题相关服务类
 * 
 * @author zhangjing
 *
 */
@Service
public class QuestionService {
	
	@Resource
	private QuestionMapper uMapper;

	/**
	 * 多条件选择查询
	 * 
	 * @param subjectname
	 *            学科名
	 * @param knowlegename
	 *            知识点名
	 * @param questionname
	 *            问题关键字
	 * @return
	 */
	public List<QuestionAndSubjectAndKnowlege> findquestion1(String subjectname, String knowlegename,
			String questionname) {
	//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	QuestionMapper uMapper = applicationContext.getBean("questionMapper", QuestionMapper.class);
		QuestionParam q = new QuestionParam();

		if ("请选择学科".equals(subjectname)) {
			// 表示用户未选择
			q.setSubject_id(0);
		} else {
			// 根据用户选择的学科名查询出学科Id
			Subject sub = uMapper.findSubjectIdBySubjectname(subjectname);
			if (sub == null) {
				// 表示没有对应学科Id
				q.setSubject_id(-1);
			} else {
				int subject_id = sub.getSubject_id();
				q.setSubject_id(subject_id);
			}
		}

		if ("请选择知识点".equals(knowlegename)) {
			// 表示用户未选择
			q.setKnowlege_id(0);
		} else {
			// 根据用户选择的知识点名查询出知识点Id
			Knowlege know = uMapper.findKnowlegeIdByKnowlegename(knowlegename);
			if (know == null) {
				// 表示没有对应知识点Id
				q.setKnowlege_id(-1);
			} else {
				int k = know.getknowlege_id();
				q.setKnowlege_id(k);
			}
		}
		if ("".equals(questionname)) {
			// 表示用户未选择
			String s = null;
			q.setQuestion_name(null);
		} else {
			// 表示用户选择
			String s = "%" + questionname + "%";
			// 查询试题
			q.setQuestion_name(s);
		}
		// 查询所有试题
		List<QuestionAndSubjectAndKnowlege> f = uMapper.findallQuestionByallchoose(q);
		if (f.size() == 0) {
			// 没有对应试题
			return null;
		} else {
			return f;
		}
	}

	/**
	 * 多条件选择查询
	 * 
	 * @param subjectname
	 *            周号或者阶段号
	 * @param district
	 *            周或者阶段类型
	 * 
	 * @param tttype
	 *            学科名
	 * @return
	 */
	public  List<QuestionAndSubjectAndKnowlege> findquestion2(String subjectname, String district,
			String tttype) {
		// System.out.println(subjectname);
		// System.out.println(tttype);
		// System.out.println(district);

//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		QuestionMapper uMapper = applicationContext.getBean("questionMapper", QuestionMapper.class);
		List<QuestionAndSubjectAndKnowlege> f = new ArrayList<QuestionAndSubjectAndKnowlege>();
		if ("请选择试卷类型".equals(district)) {
			// 表示用户未选择
		} else {
			if ("周测".equals(district)) {

				// 根据用户选择的学科名查询出学科Id

				Subject sub = uMapper.findSubjectIdBySubjectname(tttype);
				int subject_id = 0;
				int weekly_type_id = 0;
				if (sub == null) {
					// 表示没有对应学科Id
				} else {

					subject_id = sub.getSubject_id();
				}
				// 根据周类型名获取周号id
				Weekly_Type wt = uMapper.findWeekTypeByWeekName(subjectname, subject_id);
				if (wt == null) {
					// 表示没有对应周号Id
				} else {
					weekly_type_id = wt.getWeekly_type_id();
				}
				// 根据阶段id和学科id查询对应试题
				f = uMapper.findallQuestionWithWeek(weekly_type_id, subject_id);
				if (f.size() == 0) {
					// 没有对应试题
					return null;
				} else {
					return f;
				}
			} else if ("阶段测".equals(district)) {
				// 根据用户选择的学科名查询出学科Id
				Subject sub = uMapper.findSubjectIdBySubjectname(tttype);
				int stage_type_id;
				int subject_id;
				if (sub == null) {
					// 表示没有对应学科Id
					subject_id = -1;
				} else {
					subject_id = sub.getSubject_id();
				}

				// 根据阶段类型名获取id
				Stage wt = uMapper.findStageIdByStageName(subjectname);
				if (wt == null) {
					// 表示没有对应阶段Id
					stage_type_id = -1;
				} else {
					stage_type_id = wt.getStage_id();
				}

				// 根据阶段id和学科id查询对应试题
				f = uMapper.findallQuestionWithStage(stage_type_id, subject_id);
				if (f.size() == 0) {
					// 没有对应试题
					return null;
				} else {
					return f;
				}
			}
		}
		return f;

	}

	/**
	 * 根据题号删除一道试题
	 * 
	 * @param questionid
	 *            题号
	 * @return
	 */
	public int removeQuest(int questionid) {
	//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	QuestionMapper uMapper = applicationContext.getBean("questionMapper", QuestionMapper.class);
		int i = uMapper.removeQuestionById(questionid);
		return i;
	}

	/**
	 * 根据题号查询试题所有信息,包括知识点名和学科名
	 * 
	 * @param que
	 *            试题id
	 * @return List<QuestionAndSubjectAndKnowlege>试题集合
	 */
	public List<QuestionAndSubjectAndKnowlege> findQuestById(int que) {
	//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	QuestionMapper uMapper = applicationContext.getBean("questionMapper", QuestionMapper.class);
		List<QuestionAndSubjectAndKnowlege> ff = uMapper.findQuestionAllById(que);
		return ff;
	}

	/**
	 * 根据题号更改一道试题
	 * 
	 * @param question_id
	 *            试题id
	 * @param easy_type
	 *            难易程度
	 * @param question_name
	 *            试题名
	 * @param score
	 *            成绩
	 * @param option_A
	 *            A选项
	 * @param option_D
	 *            A选项
	 * @param answer
	 *            答案
	 * @param option_B
	 *            B选项
	 * @param option_C
	 *            C选项
	 * @return 影响行数
	 */
	public int UpdateQuestById(int question_id, String easy_type, String question_name, String score,
			String option_A, String option_D, String answer, String option_B, String option_C) {
	//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	QuestionMapper uMapper = applicationContext.getBean("questionMapper", QuestionMapper.class);
		uMapper.updateQuestionById(easy_type, question_name, score, option_A, option_D, answer, option_B, option_C,
				question_id);
		return 0;
	}

	/**
	 * 增加试题
	 * 
	 * @param subjectname
	 *            学科名
	 * @param knowlegename
	 *            知识点名
	 * @param easy_type
	 *            难易程度
	 * @param question_name
	 *            试题名
	 * @param score
	 *            成绩
	 * @param option_A
	 *            A选项
	 * @param option_D
	 *            A选项
	 * @param answer
	 *            答案
	 * @param option_B
	 *            B选项
	 * @param option_C
	 *            C选项
	 * @return 影响行数
	 */
	public  int addQuestById(String subjectname, String knowlegename, String question_name, String score,
			String option_A, String option_D, String answer, String option_B, String option_C, String easy_type) {
	//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	QuestionMapper uMapper = applicationContext.getBean("questionMapper", QuestionMapper.class);
		// 根据学科名查询学科id
		Subject sj = uMapper.findSubjectIdBySubjectname(subjectname);
		int subje = 0;
		if (sj == null) {
			// 表示没有对应学科Id
		} else {
			subje = sj.getSubject_id();
		}
		// 根据知识点名查询知识点id
		Knowlege kl = uMapper.findKnowlegeIdByKnowlegename(knowlegename);
		int k = 0;
		if (kl == null) {
			// 表示没有对应知识点Id
		} else {
			k = kl.getknowlege_id();
		}
		// 根据知识点Id获取阶段Id和周号id
		Knowlege kkk = uMapper.findStageAndWeekId(k);
		int stage_id = 0;
		int weekly_type_id = 0;
		if (kkk == null) {
			// 表示没有对应周号和阶段号
		} else {
			stage_id = kkk.getStage_id();
			weekly_type_id = kkk.getWeekly_type_id();
		}
		// 将接收到的score转化为double型
		double scor = (double) Integer.parseInt(score);

		Question qqq = new Question(question_name, option_A, option_B, option_C, option_D, answer, scor, easy_type, k,
				stage_id, weekly_type_id, subje, 0);
		// 插入试题
		int row = uMapper.insertQuestion(qqq);
		return row;
	}

	/**
	 * 增加一条试题
	 * 
	 * @param subjectname
	 *            学科名
	 * @param questdata
	 *            试题编号组
	 * @param tttype
	 *            周还是阶段卷
	 * @param typedetial
	 *            第几周或第几阶段
	 * @param examname
	 *            新试题名
	 * @return
	 */

	public  int addexam(String subjectname, String questdata, String tttype, String typedetial, String examname) {
		// 获取所有试题的id ，放置到questionids数组中
		
		try{
		String[] questionids = questdata.split(",");

	//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	QuestionMapper uMapper = applicationContext.getBean("questionMapper", QuestionMapper.class);
		if ("请选择试卷类型".equals(tttype)) {
			// 表示用户未选择
		} else {
			if ("周测".equals(tttype)) {

				// 根据用户选择的学科名查询出学科Id
				Subject sub = uMapper.findSubjectIdBySubjectname(subjectname);
				int subject_id = 0;
				int weekly_type_id = 0;
				if (sub == null) {
					// 表示没有对应学科Id
				} else {

					subject_id = sub.getSubject_id();
				}
				// 根据周类型名获取周号id
				Weekly_Type wt = uMapper.findWeekTypeByWeekName(typedetial, subject_id);
				if (wt == null) {
					// 表示没有对应周号Id
				} else {
					weekly_type_id = wt.getWeekly_type_id();
				}
				
				
				// 添加一周测段试题
				int ii = uMapper.addWeekExam(weekly_type_id, examname);
				int se=0;
				if (ii > 0) {
					// 根据周测题名查询试卷id
					 se = uMapper.findWeekIdByName(examname).getWeek_exam_id();
					
					
					for (int k = 0; k < questionids.length; k++) {
						String questi = questionids[k];
						// 根据周试卷编号 向阶段细节表 中插入一道试题Id

						int addStageExamDetail = uMapper.addWeekExamDetail(Integer.parseInt(questi), se);
					}
				}
				return se;
			} else if ("阶段测".equals(tttype)) {
				// 根据用户选择的学科名查询出学科Id
				Subject sub = uMapper.findSubjectIdBySubjectname(subjectname);
				int stage_type_id;
				int subject_id;
				if (sub == null) {
					// 表示没有对应学科Id
					subject_id = -1;
				} else {
					subject_id = sub.getSubject_id();
				}

				// 根据阶段类型名获取id
				Stage wt = uMapper.findStageIdByStageName(typedetial);
				if (wt == null) {
					// 表示没有对应阶段Id
					stage_type_id = -1;
				} else {
					stage_type_id = wt.getStage_id();
				}
				int se=0;
				// 添加一阶段测段试题
				int ii = uMapper.addStageExam(examname, stage_type_id);

				if (ii > 0) {
					// 根据阶段试题名查询试卷id
					se = uMapper.findStageIdByName(examname).getStage_exam_id();
					for (int k = 0; k < questionids.length; k++) {
						String questi = questionids[k];
						// 根据阶段试卷编号 向阶段细节表 中插入一道试题Id
						int addStageExamDetail = uMapper.addStageExamDetail(Integer.parseInt(questi), se);

					}
				}
				return se;
			}
		}
	}catch(Exception e){
		return 0;
	}
		return 1;
		

	}
}
