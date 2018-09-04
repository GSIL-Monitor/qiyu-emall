package com.qiyu.emall.redis;

import redis.clients.jedis.ShardedJedis;


public interface RedisDataSource {

    ShardedJedis getRedisClient();

    void returnResource(ShardedJedis shardedJedis);

    //返回资源
    void returnResource(ShardedJedis shardedJedis, boolean broken);
}
