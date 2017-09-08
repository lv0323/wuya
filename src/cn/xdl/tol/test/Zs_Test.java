package cn.xdl.tol.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xdl.tol.bean.Knowlege;
import cn.xdl.tol.bean.Question;
import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.dao.Practice_Paper_Mapper;
import cn.xdl.tol.params.Practice_PaperPO;
import cn.xdl.tol.service.PracticeService;
import cn.xdl.tol.vo.Practice_Paper_Choose_VO;
import cn.xdl.tol.vo.Practice_Paper_Easy_VO;

public class Zs_Test {
	@Test
	public void Practice_Paper_Mapper_Test1() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Practice_Paper_Mapper practice_Paper_Mapper = applicationContext.getBean("practice_Paper_Mapper", Practice_Paper_Mapper.class);
		Practice_PaperPO practice_PaperPO = new Practice_PaperPO();
		practice_PaperPO.setSubject_id(1);
		practice_PaperPO.setStage_id(2);
		practice_PaperPO.setEasy_type("难");
		int[] array = new int[]{15,16};
		practice_PaperPO.setKnowlege_ids(array);
		List<Question> findPracticePaper = practice_Paper_Mapper.findPracticePaper(practice_PaperPO);
		for (Question q : findPracticePaper) {
			System.out.println(q);
		}
		Integer findPracticePaperScore = practice_Paper_Mapper.findPracticePaperScore(practice_PaperPO);
		System.out.println("分数为" + findPracticePaperScore);
	}
	@Test
	public void Practice_Paper_Mapper_Test2() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Practice_Paper_Mapper practice_Paper_Mapper = applicationContext.getBean("practice_Paper_Mapper", Practice_Paper_Mapper.class);
		List<Knowlege> findKnowlegeBySubject_idAndStage_id = practice_Paper_Mapper.findKnowlegeBySubject_idAndStage_id(1, 1);
		for (Knowlege k : findKnowlegeBySubject_idAndStage_id) {
			System.out.println(k.getknowlege_name());
		}
	}
	@Test
	public void Practice_Paper_Mapper_Test3() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Practice_Paper_Mapper practice_Paper_Mapper = applicationContext.getBean("practice_Paper_Mapper", Practice_Paper_Mapper.class);
		List<String> findAllEasy_TypeBySubject_id = practice_Paper_Mapper.findAllEasy_TypeBySubject_id(1);
		for (String s : findAllEasy_TypeBySubject_id) {
			System.out.println(s);
		}
	}
	@Test
	public void Practice_Paper_Mapper_Test4() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		PracticeService bean = applicationContext.getBean("practiceService", PracticeService.class);
		/* <c:forEach items="${vo}" var="practice_paper_choose_VO">
		var subject_id= ${practice_paper_choose_VO.subject_id};
		<c:forEach items="${practice_paper_choose_VO.stage_list}" var="stage">
			var stage_id = ${stage.stage_id};
			$("#subject" + subject_id).click(function() {
				$(".second_menu").show();
				$(".third_menu").show();
				$(".fourth_menu").show();
				$(".second_menu li").not("#stage" + subject_id).hide(); 
			});
		</c:forEach>
	</c:forEach> */
	}
	@Test
	public void Practice_Paper_Mapper_Test5() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		PracticeService bean = applicationContext.getBean("practiceService", PracticeService.class);
		Subject findSubjectById = bean.findSubjectById(1);
		Practice_Paper_Choose_VO findPractice_Paper_Choose = bean.findPractice_Paper_Choose(findSubjectById);
		System.out.println(findPractice_Paper_Choose);
	}
	@Test
	public void Practice_Paper_Mapper_Test6() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		PracticeService bean = applicationContext.getBean("practiceService", PracticeService.class);
		Practice_Paper_Easy_VO a = bean.getPractice_Paper_Easy_VO(1);
		System.out.println(a.getKnowlege_list());
	}
}
