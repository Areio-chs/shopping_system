package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * storeLog实体类
 * @author Administrator
 *
 */
@Table(name="tb_store_log")
public class StoreLog implements Serializable{

	@Id
	private String id;//id


	

	private String storeId;//store_id

	private String operater;//操作者

	private String operating;//操作内容

	private java.util.Date operateTime;//操作时间

	private String result;//操作结果

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
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
