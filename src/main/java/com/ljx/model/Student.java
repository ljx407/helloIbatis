package com.ljx.model;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private Date birth;
	private float score;

	// 注意这里需要保证有一个无参构造方法，因为包括Hibernate在内的映射都是使用反射的，如果没有无参构造可能会出现问题
	public Student() {
		super();
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birth=" + birth + ", score=" + score + "]";
	}

}