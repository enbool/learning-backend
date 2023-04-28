package io.github.enbool.dict.integration;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 14:39
 */
public interface FileService {
    String NAMESPACE_IMAGE = "image";
    String NAMESPACE_VOICE = "voice";

    /**
     * 上传文件
     *
     * @param bytes 文件字节数组
     * @param namespace 命名空间
     * @param fileName 文件名
     * @return
     */
    String upload(byte[] bytes, String namespace, String fileName);

    /**
     * 获取文件url
     * @param fileName
     * @return
     */
    String getFileUrl(String fileName);
}
