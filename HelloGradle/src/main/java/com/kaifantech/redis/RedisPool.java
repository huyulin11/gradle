package com.kaifantech.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.kaifantech.init.sys.RelativeProgramsStart;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
	private static JedisPool jedisPool = null;
	private static String addr = "127.0.0.1";
	private static int port = 6379;
	private static String auth = "YWf^%$vvvv9868";// "YWf^%$vvvv9868";
	private static Map<String, Jedis> jedisMap = new HashMap<>();
	private static Map<String, Long> jedisExpireMap = new HashMap<>();

	static {
	}

	private synchronized static Map<String, Jedis> getJedisMap() {
		return jedisMap;
	}

	private synchronized static void init() {
		if (!SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
			initOne();
			getRedis("INIT");
		}

	}

	private static Jedis getJedis() {
		if (jedisPool != null) {
			init();
			Jedis resource = jedisPool.getResource();
			ThreadTool.sleep(1000);
			return resource;
		} else {
			return null;
		}
	}

	public synchronized static void clear() {
		try {
			Iterator<Entry<String, Jedis>> iterator = getJedisMap().entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, Jedis> entry = iterator.next();
				long current = System.currentTimeMillis();
				String key = entry.getKey();
				long thatCurrent = jedisExpireMap.get(key);
				if (current - thatCurrent > 1 * 60 * 1000) {
					close(entry.getValue());
					getJedisMap().remove(key);
					clear();
					System.out.println("Redis连接池：" + "删除key:" + key + ";" + "Active：" + jedisPool.getNumActive()
							+ "，Idle：" + jedisPool.getNumIdle() + "，Waiters：" + jedisPool.getNumWaiters() + ";");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(final Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	public static void closeAll() {
		Iterator<Entry<String, Jedis>> iterator = getJedisMap().entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Jedis> entry = iterator.next();
			close(entry.getValue());
		}
	}

	/** 单个线程中只能出现一次，否则会出错 TODO 将使用StringRedisTemplate替代该功能 */
	public synchronized static Jedis getRedis(String key) {
		Jedis jedis = getJedisMap().get(key);
		try {
			if (jedis == null) {
				jedis = getJedis();
				getJedisMap().put(key, jedis);
			}
		} catch (Exception e) {
			closeAll();
			getJedisMap().clear();
			RelativeProgramsStart.open();
			ThreadTool.sleep(1000);
		}
		try {
			jedis.ping();
		} catch (Exception e) {
			closeAll();
			getJedisMap().clear();
		}
		jedisExpireMap.put(key, System.currentTimeMillis());
		return jedis;
	}

	private synchronized static void initOne() {
		JedisPoolConfig config = new JedisPoolConfig();
		// 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
		// config.setBlockWhenExhausted(true);
		// 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
		config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
		// 是否启用pool的jmx管理功能, 默认true
		config.setJmxEnabled(true);
		// MBean ObjectName = new
		// ObjectName("org.apache.commons.pool2:type=GenericObjectPool,name="
		// + "pool" + i); 默认为"pool", JMX不熟,具体不知道是干啥的...默认就好.
		config.setJmxNamePrefix("pool");
		// 是否启用后进先出, 默认true
		config.setLifo(true);
		// 最大空闲连接数, 默认8个
		config.setMaxIdle(80);
		// 最大连接数, 默认8个
		config.setMaxTotal(80);
		// 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,
		// 默认-1
		config.setMaxWaitMillis(-1);
		// 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
		config.setMinEvictableIdleTimeMillis(1800000);
		// 最小空闲连接数, 默认0
		config.setMinIdle(0);
		// 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
		config.setNumTestsPerEvictionRun(3);
		// 对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数
		// 时直接逐出,不再根据MinEvictableIdleTimeMillis判断 (默认逐出策略)
		config.setSoftMinEvictableIdleTimeMillis(1800000);
		// 在获取连接的时候检查有效性, 默认false
		config.setTestOnBorrow(false);
		// 在空闲时检查有效性, 默认false
		config.setTestWhileIdle(false);
		// 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
		config.setTimeBetweenEvictionRunsMillis(-1);
		if (AppTool.isNull(auth)) {
			jedisPool = new JedisPool(config, addr, port, 3000);
		} else {
			jedisPool = new JedisPool(config, addr, port, 3000, auth);
		}
	}
}