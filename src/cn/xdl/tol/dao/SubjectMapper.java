package cn.xdl.tol.dao;

import java.util.List;

import cn.xdl.tol.bean.Subject;
/**
 * 
 * @author Qin
 *
 */

public interface SubjectMapper {
	/**
	 * 查询所有学科
	 * @return 存有所有学科对象的集合
	 * 
	 */
	public List<Subject> findAllSubject();
}
