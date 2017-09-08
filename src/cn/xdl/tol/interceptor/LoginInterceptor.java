package cn.xdl.tol.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		//获取请求的URL 
		  String url = request.getRequestURI(); 
		  System.out.println(url);
		  //login.jsp是可以公开访问的，其它的URL都进行拦截控制 
		  if(url.indexOf("login.do")>=0 || url.indexOf("register.do")>=0 || url.indexOf("admin.do")>=0  ){ 
		   return true; 
		  } 
		//获取Session  
		 
        HttpSession session = request.getSession();  
        String username = (String)session.getAttribute("username");  
          System.out.println(username);
        if(username != null){  
            return true;  
        }  
        //不符合条件的，跳转到登录界面  
        request.getRequestDispatcher("common_login.jsp").forward(request, response);  
          
        return false;
	}

}
