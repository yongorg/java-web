package cn.itclass.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProryTest {

    public static void main(String[] args) {
        // 1. 创建真实对象
        Lenovo lenovo = new Lenovo();

        /**
         * // 2. 代理对象增强Lenovo对象
         * 三个参数：
         *      1.类加载器 ： 真实对象.getClass().getClassLoader()
         *      2.接口数组 ：真实对象.getClass().getInterfaces()
         *      3.处理器  : new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * 代理逻辑的方法，代理对象调用的所有方法都会触发该方法执行
             * @param proxy     ：代理对象
             * @param method    ：代理对象调用的方法
             * @param args      : 方法执行时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                
                // 1. 增强参数
                // 判断是否为是sale方法
                if ("sale".equals(method.getName())){

                    // 1. 增强参数
                    double money = (double) args[0] * 0.85;
                    System.out.println("专车接送！");
                    // 使用真实对象调用该方法
                    String invoke = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    // 2. 增强返回值类型
                    return invoke+"_鼠标垫";

                }else {
                    Object invoke = method.invoke(lenovo, args);
                    return invoke;
                }

            }
        });

        // 3. proxy_lenovo调用方法
        String sale = proxy_lenovo.sale(8000);
        System.out.println(sale);

        proxy_lenovo.show();


    }

}
