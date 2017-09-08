package cn.xdl.tol.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户表
 * @author 
 *
 */
public class User implements Serializable {
	/**
	 * 编号
	 */
	private int user_id;
	/**
	 * 用户账号
	 */
	private String user_name;
	/**
	 * 密码
	 */
	private String user_pass;
	/**
	 * 年龄
	 */
	private String age;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 电话
	 */
	private String tell;
	/**
	 * 工作
	 */
	private String job;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 管理员
	 */
	private int  manager;
	/**
	 * 最后登录时间
	 * 
	 */
	private Timestamp last_time;
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_id;
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
		User other = (User) obj;
		if (user_id != other.user_id)
			return false;
		return true;
	}





	public int getUser_id() {
		return user_id;
	}





	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}





	public String getUser_name() {
		return user_name;
	}





	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}





	public String getUser_pass() {
		return user_pass;
	}





	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}





	public String getAge() {
		return age;
	}





	public void setAge(String age) {
		this.age = age;
	}





	public String getSex() {
		return sex;
	}





	public void setSex(String sex) {
		this.sex = sex;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getTell() {
		return tell;
	}





	public void setTell(String tell) {
		this.tell = tell;
	}





	public String getJob() {
		return job;
	}





	public void setJob(String job) {
		this.job = job;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public int getManager() {
		return manager;
	}





	public void setManager(int manager) {
		this.manager = manager;
	}





	public Timestamp getLast_time() {
		return last_time;
	}





	public void setLast_time(Timestamp last_time) {
		this.last_time = last_time;
	}





	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pass=" + user_pass + ", age=" + age
				+ ", sex=" + sex + ", city=" + city + ", email=" + email + ", tell=" + tell + ", job=" + job
				+ ", address=" + address + ", manager=" + manager + ", last_time=" + last_time + "]";
	}




	/**
	 * 用户类的全参构造器
	 * @param user_id 编号
	 * @param user_name 账户名
	 * @param user_pass 密码
	 * @param age 年龄
	 * @param sex 性别
	 * @param city 城市
	 * @param email 邮箱
	 * @param tell 电话
	 * @param job 工作
	 * @param address 地址
	 * @param manager 是否是管理员身份（0为否，1为是）
	 * @param last_time 最后一次登录时间
	 */
	public User(int user_id, String user_name, String user_pass, String age, String sex, String city, String email,
			String tell, String job, String address, Timestamp last_time, int manager ) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.age = age;
		this.sex = sex;
		this.city = city;
		this.email = email;
		this.tell = tell;
		this.job = job;
		this.address = address;
		this.manager = manager;
		this.last_time = last_time;
	}






	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
	
	