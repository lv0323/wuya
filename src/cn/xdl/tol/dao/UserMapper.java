package cn.xdl.tol.dao;

import java.util.List;
import java.util.Map;

import cn.xdl.tol.bean.User;

public interface UserMapper {
	/**
	 * 注册用户
	 * @param u 用户
	 * @return
	 */
	public boolean addUser(User u);
	
	/**
	 * 更改数据库中 某用户的密码 password
	 * 
	 * @param userName 准备更改的用户帐号
	 * @param newsPass 新的密码
	 * @return 修改的结果<br>
	 * true: 表示修改成功<br>
	 * false:表示修改失败
	 */
	public boolean updateUpassByName(String userName,String newsPass);
	
	/**
	 * 更改数据库中 某用户的 的登录时间和IP地址
	 * 
	 * @param userName 准备更改的用户帐号
	 * @param ipStr 新的登录Ip地址
	 * @param timeStr 新的登录时间
	 * @return 修改的结果<br>
	 * true: 表示修改成功<br>
	 * false:表示修改失败
	 */
	public boolean updateLoginTimeAndIPByName(String userName,String ipStr,String timeStr);
	
	/**
	 * 根据用户ID删除用户的操作
	 * 
	 * @param id 要删除的用户ID
	 * @return 返回删除的结果<br>
	 * 		true:表示删除成功<br>
	 * 		false:表示删除失败
	 */
	public boolean deleteUserById(int id);
	
	/**
	 * 查询单个用户的方法
	 * 
	 * @param id 要查询的用户ID
	 * @return 返回查询的结果<br>
	 * 		返回用户User对象不为空:表示查询成功<br>
	 * 		NULL:表示查询失败
	 */
	public User findUserById(int id);
	
	/**
	 * 查询所有的用户
	 * 
	 * @return 返回结为含有用户的List集合 或 null<br>
	 * 		NULL:表示查询失败
	 */
	public List<User> findAll();
	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 */
	public User findUserByName(String name);
	/**
	 * 更新用户信息
	 * @param map
	 * @return
	 */
	public boolean updateInfo(Map<String, Object> map);
	/**
	 * 更新用户密码
	 * @param map
	 * @return
	 */
	public boolean updatePassword(Map<String, Object> map);
	
}
