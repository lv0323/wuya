package cn.xdl.tol.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xdl.tol.bean.Manager;
import cn.xdl.tol.dao.ManagerMapper;
@Controller
public class ManagerController {
	@Resource
	private ManagerMapper managerDao;
	/**
	 * 管理员登陆
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/admin.do")
	@ResponseBody
	public void managerLogin(@RequestParam("username")String username, @RequestParam("password")String password,
			HttpServletRequest request, HttpServletResponse response ,HttpSession session)throws Exception{
		//System.out.println(username);
		//System.out.println(password);
		//根据传入的登录名查找管理员
		Manager name = managerDao.findManagerByName(username);
		session.setAttribute("managername", username);//将登录传出
		if(name==null){
			//用户不存在
			request.setAttribute( "name_error", "用户不存在!");
				try {
					try {
						//跳转到登陆页面
						request.getRequestDispatcher("manager_login.jsp").forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(password.equals(name.getManager_pass())){
				try {
				//跳转到后台管理页面
					//request.setAttribute("managername", username);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				//response.sendRedirect("${pageContext.request.contextPath}/index.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}else{
		//密码错误
		request.setAttribute("password_error", "密码错误");
			try {
				try {
					request.getRequestDispatcher("manager_login.jsp").forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
	/**
	 * 管理员修改密码
	 * @param login_name
	 * @param password
	 * @param password1
	 * @param password2
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/Managerchangepass.do")
	@ResponseBody
	public void changepass(String login_name,String password,String password1,String password2,
			HttpServletResponse response,HttpServletRequest request)throws IOException{
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
				request.getRequestDispatcher("manager_changepass.jsp").forward(request, response);
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
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				request.setAttribute("success", "修改失败!");
				try {
					request.getRequestDispatcher("manager_changepass.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
	}
		//用户输入的旧密码不对
		else{
			request.setAttribute("password_error", "密码错误,请检查后重新修改!");
			try {
				request.getRequestDispatcher("manager_changepass.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
