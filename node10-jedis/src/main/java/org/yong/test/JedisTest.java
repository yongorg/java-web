package org.yong.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis操作各种redis中的数据结构
 * 		1) 字符串类型 string
 * 		2) 哈希类型 hash ： map格式
 * 	    3) 列表类型 list ： linkedlist格式。支持重复元素
 * 	    4) 集合类型 set  ： 不允许重复元素
 * 	    5) 有序集合类型 sortedset：不允许重复元素，且元素有顺序*/
public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    public void test1(){
        // 1. 获取连接
        Jedis jedis = new Jedis("localhost",6379); //6379默认端口
        // 2. 操作
        jedis.set("username", "zhangsan");
        // 3. 释放资源
        jedis.close();
    }



    /**
     * 1) 字符串类型 string
     */
    @Test
    public void jedisStr(){
        // 1. 获取连接
        Jedis jedis = new Jedis(); //如果空参构造，默认值是"localhost",6379
        // 2. 操作
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        System.out.println(username);


        // 可以使用setex()方法存储可以指定过期时间的key value
        jedis.setex("lingshi", 20, "hehe"); // 将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对

        // 3. 释放资源
        jedis.close();
    }


    /**
     * 2) 哈希类型 hash ： map格式
     */
    @Test
    public void jedisHash(){
        // 1. 获取连接
        Jedis jedis = new Jedis(); //如果空参构造，默认值是"localhost",6379
        // 2. 操作
        // 设置
        jedis.hset("user", "name", "nijie");
        jedis.hset("user", "age", "18");
        jedis.hset("user", "gender", "male");
        // 获取
        String username = jedis.hget("user", "name");
        System.out.println(username);

        // 获取hash所有的map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> strings = user.keySet();
        for (String str:strings){
            System.out.println(str+":"+user.get(str));
        }

        // 3. 释放资源
        jedis.close();
    }
    /**
     * 3) 列表类型 list ： linkedlist格式。支持重复元素
     */
    @Test
    public void jedisList(){
        // 1. 获取连接
        Jedis jedis = new Jedis(); //如果空参构造，默认值是"localhost",6379
        // 2. 操作
        // 设置
        jedis.lpush("list", "a","b","c");
        jedis.rpush("list", "a","b","c");

        // list 范围获取
        List<String> mylist = jedis.lrange("list", 0, -1);
        System.out.println(mylist);

        // list 弹出
        String ele1 = jedis.lpop("list"); // c
        System.out.println(ele1);

        String ele2 = jedis.rpop("list"); // c
        System.out.println(ele2);

        System.out.println(jedis.lrange("list", 0, -1));

        // 3. 释放资源
        jedis.close();
    }

    /**
     * 4) 集合类型 set  ： 不允许重复元素
     */
    @Test
    public void jedisSet(){
        // 1. 获取连接
        Jedis jedis = new Jedis(); //如果空参构造，默认值是"localhost",6379
        // 2. 操作
        // 设置 sadd
        jedis.sadd("myset", "java", "php", "python");
        // 获取 smembers
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        // 获取
        // 3. 释放资源
        jedis.close();
    }



    /**
     * 5) 有序集合类型 sortedset：不允许重复元素，且元素有顺序
     */
    @Test
    public void jedisSortedset(){
        // 1. 获取连接
        Jedis jedis = new Jedis(); //如果空参构造，默认值是"localhost",6379
        // 2. 操作
        // 设置 zadd
        jedis.zadd("sortedset", 3, "亚瑟");
        jedis.zadd("sortedset", 25, "后羿");
        jedis.zadd("sortedset", 13, "孙悟空");

        // 获取 zrange
        Set<String> sortedset = jedis.zrange("sortedset", 0, -1);
        System.out.println(sortedset);

        // 获取
        // 3. 释放资源
        jedis.close();
    }
}
