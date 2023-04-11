package io.github.enbool.dict.model;

import io.github.enbool.dict.exception.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @author wumin2
 * @Description: API base response base, all data responses will follow this model
 */
@Schema(description = "API base response base, all data responses will follow this model")
@Data
@NoArgsConstructor
@ToString
public class Result<T> {

    /**
     * success code
     */
    public static final int OK = 0;

    @Schema(description = "Response data")
    private T data;


    @Schema(description = "Error code, please refer to the error code document for the related information of the error code.")
    private int code;


    @Schema(description = "Error message details")
    private String message;

    /**
     * constructor, success response
     * response
     *
     * @param data
     */
    public Result(T data) {
        this.data = data;
        this.code = OK;
        this.message = "success";
    }

    /**
     * constructor, error response
     *
     * @param errorCode
     * @return
     */
    public static Result error(ErrorCode errorCode) {
        Result result = new Result<>(null);
        result.setCode(errorCode.getCode());
        result.setMessage(errorCode.getDescription());
        return result;
    }

    /**
     * constructor, error response
     * @param errorCode
     * @param message
     * @return
     */
    public static Result error(ErrorCode errorCode, String message) {
        Result<Object> result = new Result<>(null);
        result.setCode(errorCode.getCode());
        result.setMessage(message);
        return result;
    }

    /**
     * success成功调用，date信息不为空
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result(data);
    }

    /**
     * success成功调用，date信息为空
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return new Result(null);
    }

    /**
     * 判断当前结果是否成功相应
     *
     * @return
     */
    public boolean isSuccess() {
        return this.code == OK;
    }

}
