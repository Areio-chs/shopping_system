package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * goodsSpec实体类
 * @author Administrator
 *
 */
@Table(name="tb_goods_spec")
public class GoodsSpec implements Serializable{

	@Id
	private Integer id;//id


	

	private String goodId;//good_id

	private String specId;//spec_id

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getSpecId() {
		return specId;
	}
	public void setSpecId(String specId) {
		this.specId = specId;
	}


	
}
