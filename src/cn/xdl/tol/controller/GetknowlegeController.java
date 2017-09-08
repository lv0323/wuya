package cn.xdl.tol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
/**
 * 
 * @author zhangjing
 *
 */
@Controller
@Transactional
public class GetknowlegeController {
	@RequestMapping("/getKnowlege.do")
	@ResponseBody
	private Object getKnowlege() {

		String s = "[{\"p\":\"请选择学科\"},{\"p\":\"Java\",\"c\":[{\"ct\":\"请选择知识点\"},{\"ct\":\"if语句\"},{\"ct\":\"for循环\"},{\"ct\":\"类\"},{\"ct\":\"面向对象\"},{\"ct\":\"构造方法\"},{\"ct\":\"this关键字\"},{\"ct\":\"封装\"},{\"ct\":\"继承\"},{\"ct\":\"多态\"},{\"ct\":\"IO流\"},{\"ct\":\"异常\"},{\"ct\":\"线程\"},{\"ct\":\"SpringIOC\"},{\"ct\":\"SpringAop\"},{\"ct\":\"SpringMVC\"},{\"ct\":\"Struts\"}]},{\"p\":\"php\",\"c\":[{\"ct\":\"请选择知识点\"},{\"ct\":\"HTML\"},{\"ct\":\"HTML+CSS\"},{\"ct\":\"JavaScript\"},{\"ct\":\"简单框架\"},{\"ct\":\"初级框架\"}]},{\"p\":\"C++\",\"c\":[{\"ct\":\"请选择知识点\"},{\"ct\":\"C/C语法\"},{\"ct\":\"C++/OOP\"},{\"ct\":\"ObjectModel\"}]},{\"p\":\"andriod\",\"c\":[{\"ct\":\"请选择知识点\"},{\"ct\":\"安卓初级\"},{\"ct\":\"安卓进阶\"},{\"ct\":\"项目实战\"}]}]";
		return s;

	}

	@RequestMapping("/gettype.do")
	@ResponseBody
	private Object gettype() {
		String s = "[{\"p\":\"请选择学科\"},{\"p\":\"java\",\"c\":[{\"ct\":\"请选择试卷类型\"},{\"ct\":\"阶段测\",\"d\":[{\"dt\":\"JAVASE\"},{\"dt\":\"JAVAEE\"},{\"dt\":\"JAVANE\"}]},{\"ct\":\"周测\",\"d\":[{\"dt\":\"第一周\"},{\"dt\":\"第二周\"},{\"dt\":\"第三周\"},{\"dt\":\"第四周\"},{\"dt\":\"第五周\"},{\"dt\":\"第六周\"}]}]},{\"p\":\"php\",\"c\":[{\"ct\":\"请选择试卷类型\"},{\"ct\":\"阶段测\",\"d\":[{\"dt\":\"PHP入门\"},{\"dt\":\"PHP高级\"},{\"dt\":\"PHP框架\"}]},{\"ct\":\"周测\",\"d\":[{\"dt\":\"第一周\"},{\"dt\":\"第二周\"},{\"dt\":\"第三周\"},{\"dt\":\"第四周\"},{\"dt\":\"第五周\"},{\"dt\":\"第六周\"}]}]},{\"p\":\"c++\",\"c\":[{\"ct\":\"请选择试卷类型\"},{\"ct\":\"阶段测\",\"d\":[{\"dt\":\"C/C语法\"},{\"dt\":\"C++/OOP\"},{\"dt\":\"ObjectModel\"}]},{\"ct\":\"周测\",\"d\":[{\"dt\":\"第一周\"},{\"dt\":\"第二周\"},{\"dt\":\"第三周\"},{\"dt\":\"第四周\"},{\"dt\":\"第五周\"},{\"dt\":\"第六周\"}]}]},{\"p\":\"andriod\",\"c\":[{\"ct\":\"请选择试卷类型\"},{\"ct\":\"阶段测\",\"d\":[{\"dt\":\"安卓初级\"},{\"dt\":\"安卓进阶\"},{\"dt\":\"项目实战\"}]},{\"ct\":\"周测\",\"d\":[{\"dt\":\"第一周\"},{\"dt\":\"第二周\"},{\"dt\":\"第三周\"},{\"dt\":\"第四周\"},{\"dt\":\"第五周\"},{\"dt\":\"第六周\"}]}]}]";
		return s;

	}

}
