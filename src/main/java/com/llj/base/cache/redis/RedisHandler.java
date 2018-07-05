/**
 * @Title: RedisHandler.java
 * @Package com.hys.framework.cache.redis
 * @author Li Lei
 * @date - 2017年1月23日
 */
package com.llj.base.cache.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * @author lu
 * @desc
 */
public interface RedisHandler<T> {

    T handler(ShardedJedis shardJedis);
}
