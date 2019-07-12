package cn.itclass.entity;


public class Person {
    private String name;
    private char sex;

    public Person() {
    }

    public Person(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void  sleap(){
        System.out.println("我是人类我aishuijiao！");
    }
}
