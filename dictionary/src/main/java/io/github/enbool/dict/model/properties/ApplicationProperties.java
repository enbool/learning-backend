package io.github.enbool.dict.model.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 13:54
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {


    private SecurityProperties security;

    @Getter
    @Setter
    public static class SecurityProperties {
        /**
         * 白名单
         */
        private List<String> whitelist;
    }
}
