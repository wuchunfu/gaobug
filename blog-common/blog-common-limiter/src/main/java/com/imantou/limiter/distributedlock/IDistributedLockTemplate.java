package com.gaobug.limiter.distributedlock;

import com.gaobug.limiter.registry.RedisLockRegistry;

import java.util.concurrent.TimeUnit;


/**
 * 分布式锁模板类
 * 默认使用{@link RedisLockRegistry}实现分布式锁，
 * 如果您对分布式锁可靠性要求非常高，可以引入Redisson并实现此接口，引入到系统中
 *
 * @author hzq
 */
public interface IDistributedLockTemplate {

    /**
     * 执行方法
     * 当获取到锁后，需要调用{@link DistributedLockCallback#onGetLock()}
     * 当获取锁超时后，需要调用{@link DistributedLockCallback#onTimeout()}
     *
     * @param lockId   锁id(对应业务唯一ID)
     * @param timeout  最大等待获取锁时间
     * @param unit     等待时间单位
     * @param callback 回调方法
     * @return 执行返回的数据
     */
    Object execute(String lockId, long timeout, TimeUnit unit, DistributedLockCallback callback);

    /**
     * 获得完整的redis key，底层可能会有所变化
     *
     * @param lockId 当前解析的key
     * @return 完整的redis key
     */
    default String completeLockKey(String lockId) {
        return lockId;
    }
}
