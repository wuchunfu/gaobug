package com.imantou.common.verify.autoconfigure;


import com.imantou.common.verify.aspect.ParamVerifyAspect;
import com.imantou.common.verify.handler.VerifyHandler;
import com.imantou.common.verify.strategy.EntityFieldVerifyStrategy;
import com.imantou.common.verify.strategy.IVerifyStrategy;
import com.imantou.common.verify.strategy.MethodParamVerifyStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author hzq
 */
@Configuration
public class VerifyAutoConfiguration {

    /*  -------------------- 参数校验相关配置  --------------------  */

    @Bean
    public EntityFieldVerifyStrategy getEntityVerifyStrategy() {
        return new EntityFieldVerifyStrategy();
    }

    @Bean
    public MethodParamVerifyStrategy getParamsVerifyStrategy() {
        return new MethodParamVerifyStrategy();
    }

    @Bean
    @ConditionalOnMissingBean
    public VerifyHandler verifyHandler(List<IVerifyStrategy> verifyStrategyList) {
        return new VerifyHandler(verifyStrategyList);
    }

    @Bean
    public ParamVerifyAspect getParamVerifyAspect(VerifyHandler verifyHandler) {
        return new ParamVerifyAspect(verifyHandler);
    }
}
