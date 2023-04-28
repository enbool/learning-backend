package io.github.enbool.dict.integration.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.DownloadUrl;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import io.github.enbool.dict.exception.BusinessErrorEnum;
import io.github.enbool.dict.exception.BusinessException;
import io.github.enbool.dict.integration.FileService;
import io.github.enbool.dict.model.properties.QiniuProperties;
import io.github.enbool.dict.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 14:39
 */
@Slf4j
@Service("qiniuFileService")
public class QiniuFileService implements FileService {
    @Autowired
    private QiniuProperties qiniuProperties;
    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private Auth auth;

    @Override
    public String upload(byte[] bytes, String namespace, String fileName) {
        String token = auth.uploadToken(qiniuProperties.getBucket(), namespace);

        try {
            Response response = uploadManager.put(bytes, fileName, token);

            DefaultPutRet putRet = JsonUtils.parse2Object(response.bodyString(), DefaultPutRet.class);

            return putRet.key;
        } catch (QiniuException e) {
            log.error("七牛云服务异常", e);
            throw new BusinessException(BusinessErrorEnum.QI_NIU_SERVICE_EXCEPTION);
        }
    }

    @Override
    public String getFileUrl(String fileName) {
        DownloadUrl url = new DownloadUrl(qiniuProperties.getUrl(), false, fileName);
        try {
            return url.buildURL(auth, Instant.now().getEpochSecond() + qiniuProperties.getUrlExpire());
        } catch (QiniuException e) {
            log.error("七牛云服务异常", e);
            throw new BusinessException(BusinessErrorEnum.QI_NIU_SERVICE_EXCEPTION);
        }
    }
}
