package com.dao;

import java.util.List;

import com.model.Key;

public interface IKey {
	public List<String> loadKeyType();//��ѯ����
	public List<String> loadKeyContent();//��ѯ�ȴ�top��
	public List<Key> loadKey();//��ѯ�ȴ�top��
	public List<Key> loadKey(String type);
	public String loadKeyCon(String content);
	//public Key loadUser(String username,String password);
	//public List<Key> loadUser(String content);//��ѯ

}
