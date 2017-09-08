package cn.xdl.tol.service;

import java.sql.Timestamp;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;


import org.springframework.stereotype.Component;

import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Stage;
import cn.xdl.tol.bean.Stage_Answer;
import cn.xdl.tol.bean.Stage_Exam;
import cn.xdl.tol.bean.Stage_Grade;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.User;
import cn.xdl.tol.dao.StageExamMapper;
import cn.xdl.tol.vo.StageExamKnowlegeVo;
import cn.xdl.tol.vo.StageExamUserQuestionVo;
@Component
public class StageExamRandomService {
	@Resource
	private StageExamMapper mapper;
	
	public  Map<String,Object> getStageExamRandomId(int stage_id){
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StageExamMapper sem = ac.getBean("stageExamMapper",StageExamMapper.class);*/
		//通过阶段id查询获得阶段试卷集合
		List<Stage_Exam> stageExamById = mapper.getStageExamById(stage_id);
		//创建一个数组长度是集合的长度
		int[] arr = new int[stageExamById.size()];
		//循环将集合中的对象放入数组下标对应位置
		for(int i=0;i<stageExamById.size();i++){
			arr[i] = stageExamById.get(i).getStage_exam_id();
		}
		//随机抽取一个数组下标
		Random ra = new Random();
		int index = ra.nextInt(arr.length);
		//找到这个数组下标对应的id
		int i = arr[index];
		//创建一个map集合
		Map<String,Object> map = new HashMap<String,Object>();
		//通过id查询数据库获得阶段试卷问题集合
		List<Question> question = mapper.getQuestionListById(i);
		//通过试卷id查询试卷信息
		Stage_Exam se = mapper.getStageExamDetailsById(i);
		//将集合放入
		map.put("question", question);
		//将试卷信息对象放入
		map.put("stageexam", se);
		return map;
	}
	/**sun
	 * 查询学科表获得所有学科集合
	 * @return 获得所有学科集合
	 */
	public List<Subject> getSubjectList(){
		List<Subject> listSubject = mapper.findAllSubject();
		return listSubject;
	}
	/**sun
	 * 查询阶段表
	 * @param subject_id 学科编号
	 * @return 对应学科的各个阶段
	 */
	public List<Stage> getStageList(Integer subject_id){
		List<Stage> listStage = mapper.getStageBySubjectId(subject_id);
		return listStage;
	}
	/**sun
	 *  查询阶段试卷表
	 * @param stage_id 阶段编号
	 * @return 阶段对应的试卷集合，可能有好几套
	 */
	public List<Stage_Exam> getStageExam(int stage_id){
		List<Stage_Exam> list = mapper.getStageExamById(stage_id);
		return list;
	}
	/**
	 * 查询数据库阶段试卷表查询试卷试题
	 * @param stage_exam_id 阶段测试卷id
	 * @return 对应试卷题集合
	 */
	public List<Question> getQuestionListById(int stage_exam_id){
		List<Question> list = mapper.getQuestionListById(stage_exam_id);
		return list;
	}
	/**
	 * 首先插入阶段成绩表自动生成阶段成绩编号
	 * @param user_id 用户编号
	 * @param stage_exam_id 阶段试卷编号
	 * @param subject_id 学科编号
	 * @param time 时间
	 */
	public void insertIntoStageGrade(Stage_Grade stage_grade){
		mapper.insertIntoStageGrade(stage_grade);
	}
	/**
	 * 查询阶段试卷成绩表
	 * @param user_id 用户编号
	 * @param time 时间
	 * @return 阶段测试卷对象
	 */
	public Stage_Grade findFromStageGrade(Stage_Grade stage_grade){
		Stage_Grade sga = mapper.findFromStageGrade(stage_grade);
		return sga;
	}
	/**
	 * 插入阶段试卷答案表
	 * @param stage_grade_id 阶段试卷成绩表
	 */
	public void insertIntoStageAnswer(Stage_Answer stage_Answer){
		mapper.insertIntoStageAnswer(stage_Answer);
	}
	/**
	 * 查询获得成绩表编号要插入到答案表时候用
	 * @param stage_exam_id 阶段试卷编号
	 * @return 阶段试卷成绩表
	 */
	public Stage_Grade findAllStageGrade(int stage_exam_id){
		Stage_Grade sg = mapper.findAllFromStageGrade(stage_exam_id);
		return sg;
	}
	/**
	 * 通过成绩表编号插入对应的总成绩
	 * @param grade
	 * @param stage_grade_id
	 */
	public void updateScore(Stage_Grade stage_grade){
		mapper.updateScore(stage_grade);
	}
	/** 
	 * 查询用户表获得而用户对象
	 * @param user_id 用户编号
	 * @return 用户对象
	 */
	public User getUserByUserId(int user_id){
		User user = mapper.getUserByUserId(user_id);
		return user;
	}
	/**
	 * 通过阶段试卷编号获得阶段试卷对象
	 */
	public Stage_Exam getStageExamByStageExamId(int stage_exam_id){
		Stage_Exam stage_exam = mapper.getStageExamByStageExamId(stage_exam_id);
		return stage_exam;
	}
	public List<StageExamKnowlegeVo> getStageExamKnowlege(int stage_exam_id,int stage_grade_id){
		List<StageExamKnowlegeVo> list = mapper.getAllKnowlegeNameAndCount(stage_exam_id);
		List<StageExamKnowlegeVo> list1 = mapper.getRightKnowlegeNameAndCount(stage_grade_id);
		List<StageExamKnowlegeVo> list2 = mapper.getRightKnowlegeIdAndRightGrade(stage_grade_id);
		for(StageExamKnowlegeVo l1:list){
			for(StageExamKnowlegeVo l2:list1){
				if(l1.getKnowlege_id()==l2.getKnowlege_id()){
					l1.setRightCount(l2.getRightCount());
				}
			}
			for(StageExamKnowlegeVo l3:list2){
				if(l1.getKnowlege_id()==l3.getKnowlege_id()){
					l1.setRightGrade(l3.getRightGrade());
				}
			}
		}
		return list;
	}
	/** 
	 * 查询表
	 * @param stage_grade_id 阶段试卷编号
	 * @return 查看答案视图对象
	 */
	public List<StageExamUserQuestionVo> getUserQuestionAnswer(int stage_grade_id){
		List<StageExamUserQuestionVo> list = mapper.getUserQuestionAnswer(stage_grade_id);
		return list;
	}
}
