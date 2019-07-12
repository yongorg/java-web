package cn.itclass.Reflect;

import cn.itclass.annotation.Pro;

import java.lang.reflect.Method;

/**
 * 框架类   2.0version
 *
 * 通过配置文件动态获取类的属性，方法、构造方法
 * 需求：写一个“框架”，不改变任何代码的前提下，可以帮助我们创建任意类对象，并且执行其中任意方法
 *
 * 实现：
 *      1.解析注解
 *      2.反射
 *
 *
 */
@Pro(className="cn.itclass.entity.Person",methodName="sleap")
public class ReflectDemo02{

    public static void main(String[] args) throws Exception {
        //1解析注解
        //1.1获取该类的Class类对象
        Class<ReflectDemo02> clazz = ReflectDemo02.class;

        //2.获取上边的注解
        //其实就是在内存中生成了一个该注解的子类实现对象
         /*
            public class ProImpl implements Pro{
                public String className(){
                    return "cn.itclass.entity.Person";
                }
                public String methodName(){
                    return "sleap";
                }
            }
         */
        Pro an = clazz.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获取返回值

        String className = an.className();
        String methodName= an.methodName();


        //3.加载该类进内存
        Class<?> cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        method.invoke(obj);

    }

}
