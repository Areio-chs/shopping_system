package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * store实体类
 * @author Administrator
 *
 */
@Table(name="tb_store")
public class Store implements Serializable{

	@Id
	private String id;//id

	private String username;//username

	private String password;//password

	private String name;//店名

	private String phone;//电话

	private String address;//地址

	private String headPic;//店铺照片

	private String status;//状态

	private java.util.Date created;//创建时间

	private java.util.Date updated;//修改时间

	private java.util.Date lastLoginTime;//最后登录时间

	private String operatorsId;//外键，关联运营商

	
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.Date getCreated() {
		return created;
	}
	public void setCreated(java.util.Date created) {
		this.created = created;
	}

	public java.util.Date getUpdated() {
		return updated;
	}
	public void setUpdated(java.util.Date updated) {
		this.updated = updated;
	}

	public java.util.Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getOperatorsId() {
		return operatorsId;
	}

	public void setOperatorsId(String operatorsId) {
		this.operatorsId = operatorsId;
	}
}
