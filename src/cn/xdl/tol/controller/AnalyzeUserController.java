package cn.xdl.tol.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.xdl.tol.bean.User;
import cn.xdl.tol.service.AnalyzeUserService;

@Controller
@Transactional
public class AnalyzeUserController {
	
	@Resource
	private AnalyzeUserService aus;
	
	@RequestMapping("/findUser.do")
	public ModelAndView findUser(@RequestParam(value="user_id",defaultValue="",required=false) String user_id,@RequestParam(value="page",defaultValue="1",required=false) int page){
		List<User> user = new ArrayList<User>();
		ModelAndView mav = new ModelAndView();
		int  totalPages = 1;
		int visiblePages = 1;
		if(user_id.length()==0){
			Page p = PageHelper.startPage(page,6);
			user = aus.findUser(0);
			
			if(p.getTotal()%6==0){
				totalPages = (int)p.getTotal()/6;
			}else{
				totalPages = (int)p.getTotal()/6+1;
			}
			visiblePages = 6;
		}else{
			int user_id1 = Integer.parseInt(user_id);
			user = aus.findUser(user_id1);
		}
		mav.getModel().put("visiblePages", visiblePages);
		mav.getModel().put("page", page);
		mav.getModel().put("totalPages", totalPages);
		mav.setViewName("analyze_user");
		mav.getModel().put("user", user);
		if(user.size()==0){
			mav.getModel().put("error", "没有用户ID为"+user_id+"的用户");
		}
		return mav;
	}
}
