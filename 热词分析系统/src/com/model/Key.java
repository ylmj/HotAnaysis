package com.model;

public class Key {
	private String key;//�ȴ�����
	private String num;//�ȴʳ��ִ���
	private String type;//�ȴ�����
	private String url;//�ȴ�����
	private String content;//�ȴ�����
	public Key() {}
	public Key(String key,String num,String type,String url,String content)
	{
		this.key=key;
		this.num=num;
		this.key=key;
		this.url=url;
		this.content=content;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


}
