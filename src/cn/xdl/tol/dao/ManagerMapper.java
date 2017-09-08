package cn.xdl.tol.dao;


import java.util.Map;

import cn.xdl.tol.bean.Manager;
/**
 * 
 * @author 于威
 *
 */
public interface ManagerMapper {

	/**
	 * 查询管理员用户的信息
	 * @return 用户信息集合
	 */
	public  Manager findManagerByName(String name);
	/**
	 * 更改管理员密码
	 * @return
	 */
	public boolean updateMpass(Map<String, Object> map);
	
}
