package io.github.enbool.dict.exception;

/**
 * @author wumin
 * @Description: error code interface
 * @date 2023年4月10日 11:15:47
 */
public interface ErrorCode {

    /**
     * retrieve error description
     *
     * @return
     */
    String getDescription();

    /**
     * retrieve error code
     *
     * @return
     */
    int getCode();

    /**
     * retrieve http status code
     *
     * @return
     */
    int getHttpStatus();
}
