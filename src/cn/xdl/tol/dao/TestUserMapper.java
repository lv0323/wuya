package cn.xdl.tol.dao;

import java.util.List;

import cn.xdl.tol.bean.User;
/**
 * 
 * @author zhangjing
 *
 */
public interface TestUserMapper {
	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> findAllUser();

	/**
	 * 插入用户
	 * 
	 * @param u
	 *            User对象
	 * @return int类型，影响几行数据
	 */
	public void insertUser(User u);
}
