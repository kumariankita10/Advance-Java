package com.entity;

public class Student {
	private int id;
	private String name;
    private String mail;
	private int age;
	
	 
	 
	 

	public Student(int int1, String string, String string2, int int2) {
	
		this.id = int1;
		this.name = string;
		this.mail = string2;
		this.age = int2;
	}

	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mail=" + mail + ", age=" + age + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	


}
