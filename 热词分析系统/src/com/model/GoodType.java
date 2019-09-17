package com.model;

public class GoodType {
	private int id;
	private String name;
	private String description;
	private int num;//数量包含该类型所有商品的
	public GoodType() {}
	public GoodType(String name,String description,int num)
	{
		this.name=name;
		this.description=description;
		this.num=num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	

}
