package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * userLog实体类
 * @author Administrator
 *
 */
@Table(name="tb_user_log")
public class UserLog implements Serializable{

	@Id
	private String id;//id


	

	private String userId;//user_id

	private String operater;//操作者

	private String operating;//操作内容

	private java.util.Date operateTime;//操作时间

	private String result;//结果

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}

	public String getOperating() {
		return operating;
	}
	public void setOperating(String operating) {
		this.operating = operating;
	}

	public java.util.Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(java.util.Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


	
}
