package cn.xdl.tol.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xdl.tol.bean.Manager;
import cn.xdl.tol.dao.ManagerMapper;

@Controller
public class ChangePasswController2 {
	@Resource
	private ManagerMapper managerDao;
	@RequestMapping("/Manchangepass.do")
	@ResponseBody
	public void excute(String login_name,String password,String password1,String password2,HttpServletResponse response,
			HttpServletRequest request) throws IOException{
	Map<String, Object> map=new HashMap<String, Object>();
	//检查登录名是否存在
	/*System.out.println(password);
	System.out.println(password1);
	System.out.println(password2);*/
	Manager name = managerDao.findManagerByName(login_name);
	System.out.println(name);
	if(name==null){
		//用户不存在
		request.setAttribute("name_error", "用户不存在,请检查后重新修改!");
		try {
			request.getRequestDispatcher("changepass.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else if(password.equals(name.getManager_pass())){
		map.put("login_name", login_name);
		map.put("password", password2);
		//System.out.println(map);
		boolean flag = managerDao.updateMpass(map);
		if(flag){
			request.setAttribute("success", "修改成功!");
			try {
				request.getRequestDispatcher("changepass.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			request.setAttribute("success", "修改失败!");
			try {
				request.getRequestDispatcher("changepass.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
}
	
	else{
		request.setAttribute("password_error", "密码错误,请检查后重新修改!");
		try {
			request.getRequestDispatcher("changepass.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
}
