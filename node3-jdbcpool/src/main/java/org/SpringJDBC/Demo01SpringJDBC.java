package org.SpringJDBC;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.utils.JDBCUtilsByDruid;

/**
 * 步骤：
 * 		1. 导入jar包
 * 		2. 创建JdbcTemplate对象。依赖于数据源DataSource
 * 			* JdbcTemplate template = new JdbcTemplate(ds);
 *
 * 		3. 调用JdbcTemplate的方法来完成CRUD的操作
 * 			* update():执行DML语句。增、删、改语句
 * 			* queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
 * 				* 注意：这个方法查询的结果集长度只能是1
 * 			* queryForList():查询结果将结果集封装为list集合
 * 				* 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
 * 			* query():查询结果，将结果封装为JavaBean对象
 * 				* query的参数：RowMapper
 * 					* 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
 * 					* new BeanPropertyRowMapper<类型>(类型.class)
 * 			* queryForObject：查询结果，将结果封装为对象
 * 				* 一般用于聚合函数的查询
 *
 *
 * 	   <!--      Springtemplate依赖以下5个jar包  -->
 *         <dependency>
 *             <groupId>commons-logging</groupId>
 *             <artifactId>commons-logging</artifactId>
 *             <version>1.2</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-beans</artifactId>
 *             <version>5.0.0.RELEASE</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-core</artifactId>
 *             <version>5.0.0.RELEASE</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-jdbc</artifactId>
 *             <version>5.0.0.RELEASE</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-tx</artifactId>
 *             <version>5.0.0.RELEASE</version>
 *         </dependency>
 *
 *
 *
 */
public class Demo01SpringJDBC {
    @Test
    public void testUpdate() {
        // 1. 导入maven依赖
        // 2. 创建JDBCTemplate
        JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());

        // 3. 调用方法
        String sql = "update student set name = 'shuaibinijie' where id = ?";
        int count = temp.update(sql, 1);

        System.out.println(count);
    }
    public void testQueryForMap() {
        // 1. 导入maven依赖
        // 2. 创建JDBCTemplate
        JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());

        // 3. 调用方法
        String sql = "update student set name = 'shuaibinijie' where id = ?";
        int count = temp.update(sql, 1);

        System.out.println(count);
    }


}
