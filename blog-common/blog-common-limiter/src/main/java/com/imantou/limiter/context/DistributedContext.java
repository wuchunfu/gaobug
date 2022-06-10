package com.gaobug.limiter.context;

import com.gaobug.limiter.extend.IDistributedLockListener;
import com.gaobug.limiter.metadata.DistributedLockMethodMetaData;
import com.gaobug.limiter.distributedlock.IDistributedLockTemplate;
import com.gaobug.limiter.extend.IAcquireLockTimeoutHandler;
import com.gaobug.base.metadata.MethodMetaData;

import java.util.List;

/**
 * 分布式锁容器
 *
 * @author hzq
 */
public interface DistributedContext {

    /**
     * 获取分布式锁模板，有可能是用户自定义的
     *
     * @return {@link IDistributedLockTemplate}
     */
    IDistributedLockTemplate getDistributedLockTemplate();

    /**
     * 获取分布式锁超时处理策略，默认为空
     *
     * @return {@link IAcquireLockTimeoutHandler}
     */
    List<IAcquireLockTimeoutHandler> getAcquireLockTimeoutHandlers();

    /**
     * 通过{@link MethodMetaData}获取超时处理策略
     *
     * @param methodMetadata {@link DistributedLockMethodMetaData}
     * @return {@link IAcquireLockTimeoutHandler}
     */
    IAcquireLockTimeoutHandler getAcquireLockTimeoutHandler(MethodMetaData methodMetadata);

    /**
     * 获取分布式锁监听器，默认为空
     *
     * @return {@link IDistributedLockListener}
     */
    List<IDistributedLockListener> getDistributedLimitListeners();

    /**
     * 获取分布式锁监听器，默认为空
     *
     * @param methodMetadata {@link DistributedLockMethodMetaData}
     * @return {@link IDistributedLockListener}
     */
    List<IDistributedLockListener> getDistributedLimitListeners(MethodMetaData methodMetadata);

}
