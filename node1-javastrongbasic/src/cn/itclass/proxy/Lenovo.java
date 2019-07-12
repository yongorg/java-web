package cn.itclass.proxy;

public class Lenovo implements SaleComputer {

    @Override
    public String sale(double money) {

        System.out.println("花了" + money + "买了个电脑！...");
        return "联想";
    }

    @Override
    public void show() {
        System.out.println("展示电脑！");
    }
}
