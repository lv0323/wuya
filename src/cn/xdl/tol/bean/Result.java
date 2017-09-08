package cn.xdl.tol.bean;

public class Result {
	private int status;
	private Object body;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	public Result(int status, Object body) {
		super();
		this.status = status;
		this.body = body;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
