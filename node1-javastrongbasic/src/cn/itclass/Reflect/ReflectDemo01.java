package cn.itclass.Reflect;

import cn.itclass.entity.Person;


import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 *
 * 通过配置文件动态获取类的属性，方法、构造方法
 * 需求：写一个“框架”，不改变任何代码的前提下，可以帮助我们创建任意类对象，并且执行其中任意方法
 *
 * 实现：
 *      1.配置文件
 *      2.反射
 * 步骤：
 * 			1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 * 			2. 在程序中加载读取配置文件
 * 			3. 使用反射技术来加载类文件进内存
 * 			4. 创建对象
 * 			5. 执行方法
 *
 */
public class ReflectDemo01{

    public static void main(String[] args) throws Exception {

//        Person p = new Person();
//        p.sleap();

        //1.加载配置文件
        //1.1创建properties对象
        Properties pro = new Properties();
        //1.2加载配置文件，转换为一个集合
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = ReflectDemo01.class.getClassLoader();//类加载器
        InputStream is = classLoader.getResourceAsStream("pro.properties");

        pro.load(is);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class<?> cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        method.invoke(obj, null);

    }

}
