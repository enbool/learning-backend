package io.github.enbool.dict.exception;

import org.springframework.http.HttpStatus;

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


    /**
     * create a static error code
     *
     * @param code
     * @param description
     * @return
     */
    static ErrorCode of(int code, String description) {
        return new ErrorCode() {
            @Override
            public String getDescription() {
                return description;
            }

            @Override
            public int getCode() {
                return code;
            }

            @Override
            public int getHttpStatus() {
                return HttpStatus.OK.value();
            }
        };
    }
}
