package com.shop.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
/**
 * goods实体类
 * @author Administrator
 *
 */
@Table(name="tb_goods")
public class Goods implements Serializable{

	@Id
	private String id;//id

	private String name;//名称

	private Double price;//价格

	private String img;//图片

	private String introduction;//简介

	private String spec;//规格，由规格表拼接而成

	private Integer stock;//库存

	private Integer sales;//销量

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date created;//创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date updated;//更新时间

	private String status;//状态

	private String categoryId;//分类

	private String storeId;
	//处理不在数据库的字段
	@Transient
	private String categoryName;//分类名
	@Transient
	private String statusName;//状态名

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	private Double freight;//运费

	
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

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
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

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}


	@Override
	public String toString() {
		return "Goods{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", price=" + price +
				", img='" + img + '\'' +
				", introduction='" + introduction + '\'' +
				", spec='" + spec + '\'' +
				", stock=" + stock +
				", sales=" + sales +
				", created=" + created +
				", updated=" + updated +
				", status='" + status + '\'' +
				", categoryId='" + categoryId + '\'' +
				", storeId='" + storeId + '\'' +
				", categoryName='" + categoryName + '\'' +
				", statusName='" + statusName + '\'' +
				", freight=" + freight +
				'}';
	}
}
