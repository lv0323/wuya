package cn.xdl.tol.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xdl.tol.bean.PracticeReport;
import cn.xdl.tol.bean.StageReport;
import cn.xdl.tol.bean.WeekReport;
import cn.xdl.tol.dao.ReportMapper;
/**
 * 导出周测试、阶段测试、刷题测试 报告的方法
 * @author CS
 *
 */
@Controller
@Transactional
public class LoadReportsController {

	@Resource
	private ReportMapper reportMapper;
	/**
	 * 导出周测报告信息的方法
	 * @param user_id	用户的ID
	 * @return	导出报告信息是否成功
	 */
	@RequestMapping("/load/weekReps.do")
	@ResponseBody
	public int loadReport(int user_id){
		//	得到用户所有周测报告列表
		List<WeekReport> list = reportMapper.findWeekReport(user_id);
		File file = new File("c://测试报告");
		//	判断测试报告文件夹存不存在，如果不存在就把它创建出来
		if(!file.exists()){
			file.mkdir();
		}
		String reportName = "周测报告";
		File file1 = new File(file,reportName);
		if(!file1.exists()){
			file1.mkdir();
		}
		//	以当前的时间为准
		java.util.Date  date = new java.util.Date(); 
		SimpleDateFormat format = new SimpleDateFormat("HH：mm：ss");
		String  hms = format.format(date);
		//	创建具体报告信息的txt文件
		File textName =new File(file1,hms+".txt");
		//	遍历报告对象集合,写入到文档中
		FileOutputStream fs;
		try {
			fs = new FileOutputStream(textName);
			for(WeekReport weekReport : list) {
				fs.write(("学科 : "+weekReport.getSubject_name()+ "\r\n").getBytes());
				fs.write(("试卷名 : "+weekReport.getWeek_exam_name()+ "\r\n").getBytes());
				fs.write(("分数 : "+weekReport.getGrade()+ "\r\n").getBytes());
				fs.write(("题数 : "+weekReport.getQuestions()+ "\r\n").getBytes());
				fs.write(("考试时间 : "+weekReport.getTime()+ "\r\n\r\n").getBytes());
			}
			fs.close();
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 导出阶段测试报告信息的方法
	 * @param user_id	用户的ID
	 * @return	导出报告信息是否成功
	 */
	@RequestMapping("/load/stageReps.do")
	@ResponseBody
	public int loadStageReport(int user_id){
		//	得到用户所有阶段测试报告列表
		List<StageReport> list = reportMapper.findStageReport(user_id);
		File file = new File("c://测试报告");
		//	判断测试报告文件夹存不存在，如果不存在就把它创建出来
		if(!file.exists()){
			file.mkdir();
		}
		String reportName = "阶段报告";
		File file1 = new File(file,reportName);
		if(!file1.exists()){
			file1.mkdir();
		}
		//	以当前的时间为准
		java.util.Date  date = new java.util.Date(); 
		SimpleDateFormat format = new SimpleDateFormat("HH：mm：ss");
		String  hms = format.format(date);
		// 	创建具体报告信息的txt文件
		File textName = new File(file1,hms+".txt");
		//	遍历报告对象集合,写入到文档中
		FileOutputStream fs;
		try {
			fs = new FileOutputStream(textName);
			for(StageReport stageReport : list) {
				fs.write(("学科 : "+stageReport.getSubject_name()+ "\r\n").getBytes());
				fs.write(("试卷名 : "+stageReport.getStage_exam_name()+ "\r\n").getBytes());
				fs.write(("分数 : "+stageReport.getGrade()+ "\r\n").getBytes());
				fs.write(("题数 : "+stageReport.getQuestions()+ "\r\n").getBytes());
				fs.write(("考试时间 : "+stageReport.getTime()+ "\r\n\r\n").getBytes());
			}
			fs.close();
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 导出刷题测试报告信息的方法
	 * @param user_id	用户的ID
	 * @return	导出报告信息是否成功
	 */
	@RequestMapping("/load/pracReps.do")
	@ResponseBody
	public int loadPracReport(int user_id){
		//	得到用户所有刷题测试报告列表信息
		List<PracticeReport> list = reportMapper.findPracticeReport(user_id);
		File file = new File("c://测试报告");
		//	判断测试报告文件夹存不存在，如果不存在就把它创建出来
		if(!file.exists()){
			file.mkdir();
		}
		String reportName = "刷题报告";
		File file1 = new File(file,reportName);
		if(!file1.exists()){
			file1.mkdir();
		}
		//以当前的时间为准
		java.util.Date  date = new java.util.Date(); 
		SimpleDateFormat format = new SimpleDateFormat("HH：mm：ss");
		String  hms = format.format(date);
		//	创建具体报告信息的txt文件
		File textName = new File(file1,hms+".txt");
		//	遍历报告对象集合,写入到文档中
		FileOutputStream fs;
		try {
			fs = new FileOutputStream(textName);
			for(PracticeReport practiceReport : list) {
				fs.write(("知识点 : "+practiceReport.getKnowlege_name()+ "\r\n").getBytes());
				fs.write(("分数 : "+practiceReport.getScore()+ "\r\n").getBytes());
				fs.write(("题数 : "+practiceReport.getCount()+ "\r\n").getBytes());
				fs.write(("时间 : "+practiceReport.getTime()+ "\r\n\r\n").getBytes());
			}
			fs.close();
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
