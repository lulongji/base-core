/**
 * @Title: JedisClient.java
 * @Package com.hys.framework.cache.redis
 * @author Li Lei
 * @date - 2017年1月23日
 */
package com.llj.base.cache.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;

/**
 * @author lu
 * @desc
 */
interface JedisClient {

    //  boolean isAlive();
    boolean expire(final String key, final int seconds);

    boolean expire(final byte[] key, final int seconds);

    Boolean set(final String key, final String value);

    //  Boolean set(final String key, final Number value);
    Boolean set(byte[] key, byte[] value);

    //  <T extends Serializable> Boolean set(final String key, final T
    // value);
    Long setnx(final String key, final String value);

    String get(final String key);

    byte[] get(final byte[] key);

    List<String> mget(final String... keys) throws Exception;

    List<String> mset(final Map<String, String> map) throws Exception;

    Boolean exists(String key);

    Long del(final String keys);

    Long del(final List<String> keys);

    Long incr(final String key);

    Long incrBy(final String key, long value);

    Long decr(final String key);

    Long decrBy(final String key, final long value);

    Set<byte[]> keys(final byte[] pattern);

    Set<String> keys(final String pattern);

    //  Boolean exists(final byte[] key);
    //  Boolean exists(String key);
    //  Long del(final byte[]... keys);
    //  Long del(final String... keys);
    Long ttl(String key);

    // #####################List操作########################
    Long rpush(final byte[] key, final byte[] value);

    Long rpush(final String key, final String value);

    Long rpush(final String key, final String[] value);

    Long lpush(final byte[] key, final byte[] value);

    Long lpush(final String key, final String value);

    Long lpush(final String key, final String[] value);

    Long lrem(String key, Long count, String value);

    String lpop(final String key);

    String rpop(String key);

    // 这2个接口目前有bug 不建议使用
    List<String> blpop(String key);

    List<String> brpop(String key);

    List<String> blpop(String key, int timeout);

    List<String> brpop(String key, int timeout);

    String lindex(String key, long index);

    List<String> lrange(String key, long start, long end);

    Long llen(final String key);

    String lset(String key, long index, String value);

    // #####################Hash表操作########################
    Long hset(String key, String field, String value);

    Long hset(byte[] key, byte[] field, byte[] value);

    Long hsetnx(String key, String field, String value);

    String hget(String key, String value);

    byte[] hget(byte[] key, byte[] field);

    String hmset(String key, Map<String, String> map);

    List<String> hmget(String key, String... fields);

    Boolean hexists(String key, String field);

    Long hincrby(String key, String field, Long value);

    Map<String, String> hgetall(String key);

    Long hdel(String key, String... fields);

    Long hdel(byte[] key, byte[] fields);

    Long hlen(String key);

    Set<String> hkeys(String key);

    Set<byte[]> hkeys(byte[] key);

    List<String> hvals(String key);

    <T extends Serializable> List<T> hvalsToObject(String key);

    // #####################Set操作########################
    Long sadd(String key, String... member);

    Long srem(String key, String... members);

    Boolean sismember(String key, String member);

    String spop(String key);

    Set<String> spop(String key, long count);

    Long scard(String key);

    Set<String> smembers(String key);

    // #####################SortedSet操作########################
    Long zadd(String key, long score, String member);

    Long zadd(String key, Map<String, Double> scoreMembers);

    Set<String> zrange(String key, long start, long end);

    Set<String> zrevrange(String key, long start, long end);

    Set<String> zrangeByScore(String key, double min, double max);

    Set<String> zrangeByScore(String key, double min, double max,
                              int offset, int count);

    Set<String> zrevrangeByScore(String key, double max, double min);

    Set<String> zrevrangeByScore(String key, double max, double min,
                                 int offset, int count);

    Long zrem(String key, String... members);

    Long zremrangeByScore(String key, String start, String end);

    Long zcount(String key, double min, double max);

    Long zcard(String key);

    Double zscore(String key, String member);

    Long zrank(String key, String member);

    Long zrevrank(String key, String member);

    // #####################pipeline操作########################
    ShardedJedisPipeline getPipeline();

    ShardedJedis getShardedJedis();

    void releaseShardedJedis(ShardedJedis shardJedis,
                             Boolean hasException);
}
