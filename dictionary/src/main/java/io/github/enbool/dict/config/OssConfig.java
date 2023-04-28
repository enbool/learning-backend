package io.github.enbool.dict.config;

import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import io.github.enbool.dict.model.properties.QiniuProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 13:48
 */
@Component
public class OssConfig {
    @Autowired
    private QiniuProperties qiniuProperties;

    @Bean
    public UploadManager uploadManager() {
        Configuration cfg = new Configuration(Region.autoRegion());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;

        return new UploadManager(cfg);
    }

    @Bean
    public Auth auth() {
        return Auth.create(qiniuProperties.getAccessKey(), qiniuProperties.getSecretKey());
    }

}
