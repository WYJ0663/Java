package com.ptwyj.main;

public class A {

	private int id;

	@AField("NEED")
	private String name;

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

	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + "]";
	}

}
