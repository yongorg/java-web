package cn.itclass.junit;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int num = c.add(5, 6);
        System.out.println(num);
    }
}
