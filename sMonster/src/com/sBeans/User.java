package com.sBeans;

public class User {
	private Long id;
	private Long todayStartPri;
	private String name;
	private String data;

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Long getTodayStartPri() { return todayStartPri; }
	public void setTodayStartPri(Long todayStartPri) { this.todayStartPri = todayStartPri; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getData() { return data; }
	public void setData(String data) { this.data = data; }
}
