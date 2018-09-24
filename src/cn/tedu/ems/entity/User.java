package cn.tedu.ems.entity;

import java.io.Serializable;

/**
 * 实体类
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 7800866169113595629L;
	private int id;
	private String username;
	private String pwd;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}










