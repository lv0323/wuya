package cn.xdl.tol.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xdl.tol.bean.Subject;
import cn.xdl.tol.dao.SubjectMapper;

public class TestSubject {
	@Test
	public void test1() throws Exception {
		ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
		SubjectMapper mapper = c.getBean("subjectMapper",SubjectMapper.class);
		List<Subject> subject = mapper.findAllSubject();
		for (Subject subject2 : subject) {
			System.out.println(subject2);
		}
		
	}
}
