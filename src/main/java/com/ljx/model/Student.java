package com.ljx.model;

import java.util.Date;
import java.util.List;

public class Student {
	private Integer id;
	private String name;
	private Date birth;
	private float score;
	private List<Cource> courceList;

	// 注意这里需要保证有一个无参构造方法，因为包括Hibernate在内的映射都是使用反射的，如果没有无参构造可能会出现问题
	public Student() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public List<Cource> getCourceList() {
		return courceList;
	}
	public void setCourceList(List<Cource> courceList) {
		this.courceList = courceList;
	}

}
