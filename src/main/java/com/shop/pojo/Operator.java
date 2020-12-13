package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * operator实体类
 * @author Administrator
 *
 */
@Table(name="tb_operator")
public class Operator implements Serializable{

	@Id
	private String id;//id


	

	private String username;//username

	private String password;//password

	private java.util.Date lastLoginTime;//最后登录时间

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public java.util.Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}


	
}
