package cn.itclass.entity;


public class student {
    private String name;
    private char sex;

    public student() {
    }
    public student(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    public void  eat(){
        System.out.println("我是学生我吃饭！");
    }
}
