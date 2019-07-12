package com.yong.request.entity;


import java.util.Date;


public class Student {
    private  Long id;
    private String name;
    private String password;
    private  String gender;
    private Double balance;
    private Integer age;
    private Date insertTime;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", balance=" + balance +
                ", age=" + age +
                ", insertTime=" + insertTime +
                '}';
    }

    public Student() {
    }

    public Student(Long id, String name, String password, String gender, Double balance, Integer age, Date insertTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.balance = balance;
        this.age = age;
        this.insertTime = insertTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}
