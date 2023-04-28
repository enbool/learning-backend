package io.github.enbool.dict.model.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 13:54
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "oss.qiniu")
public class QiniuProperties {
    /**
     * 七牛域名domain
     */
    private String url;
    /**
     * 七牛ACCESS_KEY
     */
    private String accessKey;
    /**
     * 七牛SECRET_KEY
     */
    private String secretKey;
    /**
     * 七牛空间名
     */
    private String bucket;

    private String zone;

    private Long urlExpire;
}
