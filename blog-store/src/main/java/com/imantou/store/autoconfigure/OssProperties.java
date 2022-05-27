/*
 * 爱组搭 http://aizuda.com 低代码组件化开发平台
 * ------------------------------------------
 * 受知识产权保护，请勿删除版权申明
 */
package com.imantou.store.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * <p>
 *
 * @author izyao
 * @since 2022/3/22
 */
@Setter
@Getter
@ConfigurationProperties(prefix = OssProperties.OSS_PREFIX)
public class OssProperties {

    public static final String OSS_PREFIX = "aizuda.oss";

    private String platform;


    /**
     * 域名
     */
    private String endpoint;

    /**
     * 前缀
     */
    private String prefix;

    /**
     * ACCESS_KEY
     */
    private String accessKey;

    /**
     * SECRET_KEY
     */
    private String secretKey;

    /**
     * 存储空间名
     */
    private String bucketName;

    /**
     * 存储区域
     */
    private String region;

    /**
     * 是否https（Y=是,N=否）
     */
    private String isHttps;

}
