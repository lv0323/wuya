package cn.xdl.tol.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xdl.tol.bean.Knowlege;
import cn.xdl.tol.bean.Practice_Question;
import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Stage;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.bean.User;
import cn.xdl.tol.dao.Practice_Paper_Mapper;
import cn.xdl.tol.dao.StageExamMapper;
import cn.xdl.tol.dao.SubjectMapper;
import cn.xdl.tol.params.InsertPracticePO;
import cn.xdl.tol.params.Practice_PaperPO;
import cn.xdl.tol.vo.Practice_KResult;
import cn.xdl.tol.vo.Practice_Max_User_VO;
import cn.xdl.tol.vo.Practice_Paper_Choose_VO;
import cn.xdl.tol.vo.Practice_Paper_Easy_VO;

/**
 * 有关practice操作的业务层
 * @author Administrator
 *
 */
@Service
public class PracticeService {
	/**
	 * 使用别人写的用于通过subject_id获取所有stage阶段信息的dao对象
	 */
	@Resource
	private StageExamMapper stageExamMapper;
	/**
	 * 使用别人写的用于查询所有subject信息的dao对象
	 */
	@Resource
	private SubjectMapper subjectMapper;
	/**
	 * 要使用的Practice_Paper_Mapper对象
	 */
	@Resource
	private Practice_Paper_Mapper practice_Paper_Mapper;
	
	/**
	 * 根据学科对象获取单个学科的vo展示对象
	 * @param s 学科对象
	 * @return 返回学科对应的学科vo对象
	 */
	public Practice_Paper_Choose_VO findPractice_Paper_Choose(Subject s) {
			//遍历学科信息并将学科信息存入到刷题选择的vo对象中
			Practice_Paper_Choose_VO vo = new Practice_Paper_Choose_VO();
			vo.setSubject_id(s.getSubject_id());
			vo.setSubject_name(s.getSubject_name());
			//通过学科id查询出该学科的阶段信息并将其放入到vo对象中
			List<Stage> stageBySubjectId = stageExamMapper.getStageBySubjectId(s.getSubject_id());
			vo.setStage_list(stageBySubjectId);
			//创建一个集合将知识点集合放入到集合中，最后将此集合放入vo对象中
			List<List<Knowlege>> knowlege_list = new ArrayList<>();
			for (Stage stage : stageBySubjectId) {
				List<Knowlege> findKnowlegeBySubject_idAndStage_id = practice_Paper_Mapper.findKnowlegeBySubject_idAndStage_id(s.getSubject_id(), stage.getStage_id());
				knowlege_list.add(findKnowlegeBySubject_idAndStage_id);
			}
			vo.setKnowlege_list(knowlege_list);
			//获取当前学科所有试题难度并放入到vo对象中
			List<String> findAllEasy_TypeBySubject_id = practice_Paper_Mapper.findAllEasy_TypeBySubject_id(s.getSubject_id());
			vo.setEasy_type(findAllEasy_TypeBySubject_id);
			return vo;
	}
	/**
	 * 获取全部学科
	 * @return 返回全部学科的集合
	 */
	public List<Subject> findAllSubject() {
		List<Subject> findAllSubject = subjectMapper.findAllSubject();
		return findAllSubject;
	}
	/**
	 * 通过学科id获取学科
	 * @param subject_id 要获取的学科id
	 * @return 返回学科对象
	 */
	public Subject findSubjectById(Integer subject_id) {
		Subject findSubjectById = practice_Paper_Mapper.findSubjectById(subject_id);
		return findSubjectById;
	}
	/**
	 * 通过学科id获取简单版刷题选择vo对象
	 * @param subject_id 学科id
	 * @return 返回简单版刷题vo选择对象
	 */
	public Practice_Paper_Easy_VO getPractice_Paper_Easy_VO(Integer subject_id) {
		List<Knowlege> findAllKnowledgeBySubject_id = practice_Paper_Mapper.findAllKnowledgeBySubject_id(subject_id);
		List<String> findAllEasy_TypeBySubject_id = practice_Paper_Mapper.findAllEasy_TypeBySubject_id(subject_id);
		Practice_Paper_Easy_VO vo = new Practice_Paper_Easy_VO();
		vo.setKnowlege_list(findAllKnowledgeBySubject_id);
		vo.setEasy_type(findAllEasy_TypeBySubject_id);
		return vo;
	}
	/**
	 * 查询试题中包含的所有学科
	 * @return 返回包含的学科集合
	 */
	public List<Subject> findSubjectHaveQuestion() {
		List<Integer> findSubjectIdFromQuestion = practice_Paper_Mapper.findSubjectIdFromQuestion();
		List<Subject> list = new ArrayList<>();
		for (Integer subject_id : findSubjectIdFromQuestion) {
			Subject findSubjectById = practice_Paper_Mapper.findSubjectById(subject_id);
			list.add(findSubjectById);
		}
		return list;
	}
	/**
	 * 根据用户选择的知识点和难度进行试题筛选
	 * @param knowledge_ids 用户选择知识点
	 * @param easy_type 用户选择难度
	 * @return 返回符合要求的试题集合
	 */
	public List<Question> getPracticePaper(String knowledge_ids, String easy_type) {
		Practice_PaperPO po = new Practice_PaperPO();
		if (!"".equals(knowledge_ids)) {
			String[] split_knowledge_ids = knowledge_ids.split(",");
			int[] array = new int[split_knowledge_ids.length];
			for (int i = 0; i < split_knowledge_ids.length; i++) {
				array[i] = Integer.parseInt(split_knowledge_ids[i]);
			}
			po.setKnowlege_ids(array);
		}
		if (!"undefined".equals(easy_type)){
			po.setEasy_type(easy_type);
		}
		List<Question> list = practice_Paper_Mapper.findPracticePaper(po);
		return list;
	}
	/**
	 * 获取通过用户选择的知识点和难度筛选出的试题的总分数
	 * @param knowledge_ids 用户选择的知识点
	 * @param easy_type 用户选择的难度
	 * @return 返回符合要求的试题的总分数
	 */
	public Integer getPracticePaperScore(String knowledge_ids, String easy_type) {
		Practice_PaperPO po = new Practice_PaperPO();
		if (!"".equals(knowledge_ids)) {
			String[] split_knowledge_ids = knowledge_ids.split(",");
			int[] array = new int[split_knowledge_ids.length];
			for (int i = 0; i < split_knowledge_ids.length; i++) {
				array[i] = Integer.parseInt(split_knowledge_ids[i]);
			}
			po.setKnowlege_ids(array);
		}
		if (!"undefined".equals(easy_type)){
			po.setEasy_type(easy_type);
		}
		Integer score = practice_Paper_Mapper.findPracticePaperScore(po);
		return score;
	}
	/**
	 * 刷题分析核心逻辑
	 * @param total 本次刷题总题数
	 * @param answer 用户答题答案
	 * @param user_id 用户id
	 * @param total_score 刷题试卷总分
	 * @return 返回存放各种需要展示数据的map
	 */
	public Map<String,Object> submitPractice(int total, String[] answer, int user_id, int total_score) {
		//定义一个总分和用户得分总分
		double get_score = 0;
		//定义一个集合装入用户作答题目
		List<Question> qlist = new ArrayList<>();
		//定义集合装入用户选择
		List<String> uchoose = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			String[] idAndchoose = answer[i].split(",");
			//拿出用户答题的题号和答案
			int qid = Integer.parseInt(idAndchoose[0]);
			String qanswer = idAndchoose[1];
			uchoose.add(qanswer);
			//查找试题对象
			Question question = practice_Paper_Mapper.findQuestionById(qid);
			qlist.add(question);
			if (qanswer.equalsIgnoreCase(question.getAnswer())) {
				get_score+=question.getScore();
			}
		}
		//创建插入刷题表po对象并插入刷题表
		InsertPracticePO po = new InsertPracticePO();
		po.setCount(total);
		po.setScore(get_score);
		po.setUser_id(user_id);
		practice_Paper_Mapper.insertPractice(po);
		//通过用户id查询最新的刷题id
		Integer lastpractice_id = practice_Paper_Mapper.findLastPracticeByUser_Id(user_id);
		//创建一个日期
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日  HH时:mm分");
		String time = sdf.format(date);
		
		//创建Practice_Question对象
		for (int i = 0; i < total; i++) {
			Practice_Question pq = new Practice_Question();
			pq.setPractice_id(lastpractice_id);
			pq.setQuestion_id(qlist.get(i).getQuestion_id());
			//拿出用户答题的题号和答案
			String[] idAndchoose = answer[i].split(",");
			String qanswer = idAndchoose[1];
			pq.setUser_answer(qanswer);
			//插入刷题答案表
			practice_Paper_Mapper.insertPractice_Question(pq);
		}
		//遍历答题题目并将信息存入答题分析对象vo中
		//创建一个map，key装入知识点名称，value装入vo对象
		Map<String,Practice_KResult> map = new HashMap<>();
		for (int i = 0; i < qlist.size(); i++) {
			Integer knowlege_id = qlist.get(i).getKnowlege_id();
			String knowlege_name = practice_Paper_Mapper.findKnowlege_NameById(knowlege_id);
			Practice_KResult practice_KResult = map.get(knowlege_name);
			//拿出用户答题答案
			String[] idAndchoose = answer[i].split(",");
			String qanswer = idAndchoose[1];
			if (practice_KResult == null) {//判断是否有这个知识点vo对象，没有即创建并放入知识点名称等后存入map中
				Practice_KResult pk = new Practice_KResult();
				pk.setKnowlege_name(knowlege_name);
				if (qanswer.equalsIgnoreCase(qlist.get(i).getAnswer())) {
					pk.setRight(1);
					pk.setUser_score(qlist.get(i).getScore());
				} else {
					pk.setRight(0);
					pk.setUser_score(0.0);
				}
				pk.setTotal_question(1);
				pk.setTotal_socre(qlist.get(i).getScore());
				map.put(knowlege_name, pk);
			} else {//存在即叠加值
				if (qanswer.equalsIgnoreCase(qlist.get(i).getAnswer())) {
					practice_KResult.setRight(practice_KResult.getRight() + 1);
					practice_KResult.setUser_score(practice_KResult.getUser_score() + qlist.get(i).getScore());
				}
				practice_KResult.setTotal_question(practice_KResult.getTotal_question() + 1);
				practice_KResult.setTotal_socre(practice_KResult.getTotal_socre() + qlist.get(i).getScore());
			}
		}
		//创建一个集合将vo从map取出放入，方便前台展示
		List<Practice_KResult> rlist = new ArrayList<>();
		Set<String> keySet = map.keySet();
		for (String s : keySet) {
			rlist.add(map.get(s));
		}
		//判断属于什么等级 
		Double dd = get_score * 100/total_score;
		Integer rank = null;
		if (dd <60) {
			rank = 4;
		} else if (dd>=60 && dd<75) {
			rank = 3;
		} else if (dd >=75 && dd<85) {
			rank = 2;
		} else if (dd>=85) {
			rank =1;
		}
		User user = practice_Paper_Mapper.findUserById(user_id);
		//
		List<Practice_Max_User_VO> pvo = practice_Paper_Mapper.findMaxPracticeUser();
		List<String> topuname = new ArrayList<>();
		List<Integer> topucount = new ArrayList<>();
		for (Practice_Max_User_VO vo : pvo) {
			User u = practice_Paper_Mapper.findUserById(vo.getUser_id());
			topuname.add(u.getUser_name());
			topucount.add(vo.getCount());
		}
		
		//创建一个map用于存放对象，返回给controller
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("questions", qlist);
		rmap.put("vo", rlist);
		rmap.put("total_score",total_score);
		rmap.put("user_score", get_score);
		rmap.put("rank", rank);
		rmap.put("uchoose", uchoose);
		rmap.put("time", time);
		rmap.put("user", user);
		rmap.put("topuname", topuname);
		rmap.put("topucount", topucount);
		return rmap;
	}
	
}
