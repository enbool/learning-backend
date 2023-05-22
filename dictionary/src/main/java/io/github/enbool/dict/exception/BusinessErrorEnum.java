package io.github.enbool.dict.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wumin
 * @Description: 通用业务异常
 * @date 2023年4月10日 11:15:47
 */
@Schema(description = "基础错误码。前面两位是具体模块[10是内部通用异常， 11-69是各模块内部编号，70-99是外部依赖系统编号]， 最后三位是具体错误码")
@AllArgsConstructor
public enum BusinessErrorEnum implements ErrorCode {
    /**
     * 参数异常
     */
    PARAM_INVALID_ERROR(10001, 400, "Invalid parameter"),

    /**
     * DB执行异常
     */
    DB_ERROR(10002, 500, "Server execution exception"),

    /**
     * 出现未预料的未知异常
     */
    UNKNOWN_ERROR(10003, 500, "Unknown exception"),

    /**
     * token异常，需要重新登录
     */
    TOKEN_ERROR(10004, 401, "Authentication failed, please sign in again"),


    /**
     * 用户信息异常，重新登录
     */
    USER_INFO_ERROR(10006, 401, "User information exception, please log in again"),

    JSON_SERIALIZE_ERROR(10010, 400, "JSON serialization error"),
    /**
     * 操作过于频繁，请稍后再试
     **/
    OPERATION_FREQUENTLY(10028, 500, "Operation too frequently, please try again later"),

    /********************* 以下为自定义错误码 **********************/
    /**
     * 单词本中有单词，所以不能删除
     */
    DICTIONARY_NOT_EMPTY(11001, 200, "Dictionary is not empty, so it cannot be deleted"),


    QI_NIU_SERVICE_EXCEPTION(20001, 500, "QiNiu service exception"),

    ;

    /**
     * error code
     */
    @Getter
    private int code;

    /**
     * http status code
     */
    @Getter
    private int httpStatus;
    /**
     * description
     */
    @Getter
    private String description;


}
