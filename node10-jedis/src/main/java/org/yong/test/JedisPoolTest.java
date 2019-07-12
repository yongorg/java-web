package org.yong.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {

    @Test
    public void test01() {
        // 0. 创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        // 1. 创建连接池对象
//        JedisPool jedisPool = new JedisPool();
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        // 2. 调用方法，getResources（）获取jedis连接
        Jedis jedis = jedisPool.getResource();

        // 3. 使用
        jedis.set("haha", "nijie");
        String haha = jedis.get("haha");
        System.out.println(haha);

        // 4. 关闭 （归还到连接池中）
        jedis.close();

    }

    /**
     * 测试JedisPoolUtils
     */
    @Test
    public void test02() {
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("jedispool", "nijie");
        String jedispool = jedis.get("jedispool");
        System.out.println(jedispool);

        jedis.close();
    }
}
