package cn.itclass.Reflect;

import cn.itclass.Reflect.anno.Check;
import cn.itclass.Reflect.entity.Calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单的测试“框架”
 *  利用反射+注解技术
 *
 *  当主方法执行后，会自动自行被检测的所有方法（加了Check注解的方法），判断方法是否有异常，然后记录到文件中
 */
public class 测试框架 {

    public static void main(String[] args) throws IOException {
        //1.创建的测试对象
        Calculator c = new Calculator();
        //2.获取字节码文件对象
        Class<?> clazz = c.getClass();
        //3.获取所有方法
        Method[] methods = clazz.getMethods();

        int number = 0;//记录异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java\\ideaprojects\\Java基础加强\\src\\bug.txt"));



        for (Method method : methods){
            //4.判断方法上是否有Check注解
            // 5.有就执行
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                }catch (Exception e){
                    //6.捕获异常

                    //记录到文件中
                    number ++;

                    bw.write(method.getName()+"方法出现异常");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现"+number+"次异常");

        bw.flush();
        bw.close();

    }

}
