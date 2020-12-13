package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * category实体类
 * @author Administrator
 *
 */
@Table(name="tb_category")
public class Category implements Serializable{

	@Id
	private String id;//id


	

	private String name;//name

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
}
