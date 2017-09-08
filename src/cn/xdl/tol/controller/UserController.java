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
import cn.xdl.tol.bean.User;
import cn.xdl.tol.dao.UserMapper;

@Controller
public class UserController {
	@Resource
	private UserMapper userDao;
	@RequestMapping("/common_login.do")
	@ResponseBody
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void userLogin(@RequestParam("username")String username, @RequestParam("password")String password,
			HttpServletRequest request, HttpServletResponse response,HttpSession session)throws Exception{
		System.out.println(username);
		System.out.println(password);
		//根据传入的登录名查找管理员
		User name = userDao.findUserByName(username);
		//将登录传出
		session.setAttribute("username", username);
		if(name==null){
			//用户不存在
			request.setAttribute( "name_error", "用户不存在!");
				try {
					try {
						//跳转到登陆页面
						request.getRequestDispatcher("common_login.jsp").forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(password.equals(name.getUser_pass())){
				//用户存在且密码正确
			try {
				try {
					//跳转到后台管理页面
					request.getRequestDispatcher("home_index.jsp").forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}else{
		//密码错误
		request.setAttribute("password_error", "密码错误");
			try {
				try {
					request.getRequestDispatcher("common_login.jsp").forward(request, response);
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
	 * 用户修改密码
	 * @param login_name
	 * @param password
	 * @param password1
	 * @param password2
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/changepass.do")
	@ResponseBody
	public void changepass(String login_name,String password,String password1,String password2,
			HttpServletResponse response,HttpServletRequest request)throws IOException{
		Map<String, Object> map=new HashMap<String, Object>();
		//检查登录名是否存在
		/*System.out.println(password);
		System.out.println(password1);
		System.out.println(password2);*/
		User name = userDao.findUserByName(login_name);
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
		}//用户存在且密码相等
		else if(password.equals(name.getUser_pass())){
			map.put("login_name", login_name);
			map.put("password", password2);
			//System.out.println(map);
			//判断是否修改成功
			boolean flag = userDao.updatePassword(map);
			if(flag){
				request.setAttribute("success", "修改成功!");
				try {
					request.getRequestDispatcher("user_centre.jsp").forward(request, response);
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
		//用户存在但密码不相等
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
	/**
	 * 用户注册
	 * @param login_name
	 * @param password
	 * @param email
	 * @param request
	 * @param response
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public void toRegister(String login_name,String password,String email,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		User u=new User();
		//用户信息添加进User
		u.setUser_name(login_name);
		u.setUser_pass(password);
		u.setEmail(email);
		//判断是否修改成功
		boolean flag = userDao.addUser(u);
		if(flag){
			try {
				//修改成功将username 存入session
				session.setAttribute("username", login_name);
				request.getRequestDispatcher("registerOk.jsp").forward(request, response);
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		//不成功 跳转到注册页面
		else{
			try {
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
	
	/**
	 * 修改用户信息
	 * 
	 * @param login_name
	 * @param email
	 * @param age
	 * @param sex
	 * @param city
	 * @param tell
	 * @param job
	 * @param address
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/changeInfo.do")
	@ResponseBody
	public void changeInfo(String login_name,String email,String age,String sex,
			String city,String tell,String job,String address,
			HttpServletResponse response,HttpServletRequest request) throws IOException{
		//新建集合 将信息存入集合
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("login_name", login_name);
		map.put("email", email);
		map.put("age", age);
		map.put("sex", sex);
		map.put("address", address);
		map.put("tell", tell);
		map.put("city", city);
		map.put("job", job);
		System.out.println(map);
		User name = userDao.findUserByName(login_name);
		//如果用户不存在 跳转到登陆页面
		if(name==null){
			try {
				request.getRequestDispatcher("common_login.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//用户存在
		else{
			boolean flag = userDao.updateInfo(map);
			if(flag){
				//更新成功
				try {
					request.getRequestDispatcher("changeOk.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				//更新失败
				try {
					request.getRequestDispatcher("changeError.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
	}
	
}