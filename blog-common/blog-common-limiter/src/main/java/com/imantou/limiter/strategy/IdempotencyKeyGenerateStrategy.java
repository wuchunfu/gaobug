package com.imantou.limiter.strategy;


import com.imantou.limiter.RateLimit;
import com.imantou.base.metadata.MethodMetaData;
import com.imantou.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.lang.annotation.Annotation;
import java.nio.charset.StandardCharsets;
import java.util.SortedMap;

/**
 * 接口幂等性
 *
 * @author hzq
 */
@Slf4j
public class IdempotencyKeyGenerateStrategy implements IKeyGenerateStrategy {

    @Override
    public boolean supports(Annotation annotation) {
        if (annotation instanceof RateLimit) {
            return true;
        }
        log.error("IdempotencyKeyGenerateStrategy not supports type:" + annotation.annotationType());
        return false;
    }

    @Override
    public Strategy getType() {
        return Strategy.IDEMPOTENCY;
    }

    @Override
    public String getKey(MethodMetaData methodMetadata, String parseKey) {
        SortedMap<String, String> argsMap = methodMetadata.getArgsMap();
        if (!ObjectUtils.isEmpty(argsMap)) {
            argsMap.remove("timestamp");
            argsMap.remove("sign");
            argsMap.remove("nonce");
            String jsonString = JacksonUtils.toJSONString(argsMap);
            return DigestUtils.md5DigestAsHex(jsonString.getBytes(StandardCharsets.UTF_8));
        }
        return "";
    }
}
