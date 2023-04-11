package io.github.enbool.dict.exception;


import lombok.Getter;

/**
 * @author wumin
 * @description 通用业务异常
 * @date 2023/4/10 5:50 下午
 */
public class BusinessException extends RuntimeException {

    /** error code */
    @Getter
    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }


    /**
     * 构造函数
     *
     * @param errorCode
     * @param message
     */
    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 构造函数
     *
     * @param errorCode
     * @param message
     */
    public BusinessException(ErrorCode errorCode, String format, Object... message) {
        super(String.format(format, message));
        this.errorCode = errorCode;
    }

    /**
     *
     * @param exception
     */
    public BusinessException(Exception exception, ErrorCode errorCode) {
        super(exception);
        this.errorCode = errorCode;
    }

    /**
     *
     * @param exception
     * @param errorCode
     * @param format
     * @param message
     */
    public BusinessException(Exception exception, ErrorCode errorCode, String format, Object... message) {
        super(String.format(format, message), exception);
        this.errorCode = errorCode;
    }

    /**
     * 快速抛出业务异常
     *
     * @param errorCode
     * @param format
     * @param message
     */
    public static void throwException(ErrorCode errorCode, String format, Object... message) {
        throw new BusinessException(errorCode, String.format(format, message));
    }

}
