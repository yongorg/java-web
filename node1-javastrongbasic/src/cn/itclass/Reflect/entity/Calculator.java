package cn.itclass.Reflect.entity;

import cn.itclass.Reflect.anno.Check;

public class Calculator {

    //加法
    @Check
    public void add(){
        String a = null;
        System.out.println(a.toString());
        System.out.println("1 + 0 ="+(1 + 0));
    }

    //减法
    @Check
    public  void sub(){
        System.out.println("1 - 0 = "+(1 - 0));
    }

    //除法
    @Check
    public  void div(){
        System.out.println("1 / 0 ="+(1 / 0));
    }

    //乘法
    @Check
    public void mul(){
        System.out.println("1 * 0 ="+(1 * 0));
    }

    @Check
    public void  show(){
        System.out.println("永无BUG....");
    }
    public void shows(){
        System.out.println("sasas...");
    }
}
