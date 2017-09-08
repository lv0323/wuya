package cn.xdl.tol.bean;

import java.io.Serializable;
/**
 * 管理员表
 * @author 
 *
 */
public class Manager implements Serializable {

	private int manager_id;
	private String manager_name;
	private String manager_pass;
	
	public Manager() {
		super();
	}
	public Manager(int manager_id, String manager_name, String manager_pass) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.manager_pass = manager_pass;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_pass() {
		return manager_pass;
	}
	public void setManager_pass(String manager_pass) {
		this.manager_pass = manager_pass;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + manager_id;
		result = prime * result + ((manager_name == null) ? 0 : manager_name.hashCode());
		result = prime * result + ((manager_pass == null) ? 0 : manager_pass.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (manager_id != other.manager_id)
			return false;
		if (manager_name == null) {
			if (other.manager_name != null)
				return false;
		} else if (!manager_name.equals(other.manager_name))
			return false;
		if (manager_pass == null) {
			if (other.manager_pass != null)
				return false;
		} else if (!manager_pass.equals(other.manager_pass))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Manager [manager_id=" + manager_id + ", manager_name=" + manager_name + ", manager_pass=" + manager_pass
				+ "]";
	}
	
}
