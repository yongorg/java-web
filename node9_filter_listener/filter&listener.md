## Filter : 过滤器
    1 概念
        * 生活中的过滤器： 净水器，空气净化器
        * web中的过滤器： 当访问服务器的资源时，过滤器可以将请求拦截下来，完成一些特殊的功能
        * 过滤器的作用L
            * 一般用于完成通用的操作： 如：登录验证、统一代码处理、铭感字符过滤...
            
    2 快速入门：
        1. 步骤： 
           1. 定义一个类，实现接口Filter (javax.servlet)
           2. 复写方法
           3. 配置拦截路径   
                1. web.xml配置
                2. 注解配置
    
    3. 过滤器细节
        1. web.xml配置
            <filter>
                <filter-name>demo01</filter-name>
                <filter-class>cn.filter.FliterDemo01</filter-class>
              </filter>
              <filter-mapping>
                <filter-name>demo01</filter-name>
                <url-pattern>/*</url-pattern>
              </filter-mapping>
              
        2. 过滤器执行流程
        3. 过滤器生命周期
               init（）： 在服务器启动后会创建filter对象，调用init方法，只执行一次
               doFilter（）： 每一次请求被拦截时会执行，可执行多次每一次请求被拦截时会执行doFilter（），可执行多次
               destroy（）： 在服务器关闭后，filter对象被销毁，如果服务器正常关闭，则会执行destroy方法，只执行一次
        
        4. 过滤器配置详解
            * 拦截路径配置
                1. 具体资源路径： /index.jsp  只有访问index.jsp资源时，过滤器才会被执行
                2. 拦截目录： /user/*   访问/user下的所有资源时，过滤器都会被执行
                3. 后缀名拦截： *.jsp  访问虽有jsp资源时，过滤器都会被执行。
                4. 拦截所有资源： /*   访问所有资源时，过滤器都会被执行。
            * 拦截方式配置： 资源被访问的方式
                1. 注解配置
                    * 设置属性 dispatcherTypes属性
                        1. REQUEST: 默认值。 浏览器直接请求资源
                        2. FORWORD: 转发访问资源
                        3. INCLUDE：包含访问资源
                        4. ERROR:   错误跳转资源
                        5. ASYNC:   异步访问资源
                2. web.xml配置
                    * 设置<dispatchar></dispatchar>标签即可
                    
        5. 过滤器链（配置多个过滤器）
            执行顺序：如果有两个过滤器：
                1. 过滤器1
                2. 过滤器2
                3. 资源执行
                4. 过滤器2
                5. 过滤器1
            * 过滤器先后顺序问题
                1. 注解配置：按照类名的字符串比较规则比较，值小的先执行
                    如： AFilter   -->  BFilter
                2. web.xml 配置： 谁定义在上面，谁先执行
                
## listener : 监听事件
    * 概念： web的三大组件之一
        * 事件监听机制：
            * 事件： 一件事情
            * 事件源： 事件发生的地方
            * 监听器： 一个对象
            * 注册监听：将事件、事件源、监听器绑定在一起。当事件源发生某个事件后，执行监听器代码
            
    * ServletContextListener：监听ServletContext对象的创建和销毁
    
    * 步骤：
        1. 定义一个类实现接口ServletContextListener
        2. 复写方法
        3. 配置
            1. web.xml
            2. 注解配置