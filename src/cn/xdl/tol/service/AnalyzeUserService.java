package cn.xdl.tol.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xdl.tol.bean.User;
import cn.xdl.tol.dao.AnalyzeUserMapper;

@Component
public class AnalyzeUserService {
	
	@Resource
	private AnalyzeUserMapper aum;
	
	/**
	 * 根据用户id查询用户
	 * @param user_id 用户id
	 * @return 存有用户信息的集合
	 */
	public List<User> findUser(int user_id){
		List<User> user = aum.findUser(user_id);
		return user;
	}
}
