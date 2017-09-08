package cn.xdl.tol.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xdl.tol.bean.User;


public interface AnalyzeUserMapper {
	/**
	 * 根据用户id查询用户
	 * @param user_id 用户id
	 * @return 存有用户信息的集合
	 */
	public List<User> findUser(@Param("user_id") int user_id);
}
