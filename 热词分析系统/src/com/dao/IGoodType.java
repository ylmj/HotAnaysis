package com.dao;

import java.util.List;

import com.model.GoodType;

public interface IGoodType {
	public void addType(GoodType type);
	public void updateType(GoodType type);
	public void deleteType(int id);
	public List<GoodType>load(String name);
	public GoodType load(int id);
	public GoodType loadOne(String name);
	public void updateTypeNum(int id);

}
