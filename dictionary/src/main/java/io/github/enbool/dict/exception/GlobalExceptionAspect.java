package io.github.enbool.dict.exception;

import io.github.enbool.dict.model.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static io.github.enbool.dict.exception.BusinessErrorEnum.*;

/**
 * @author wumin
 * @Description:
 * @date 2021年05月31日 7:07 下午
 */
@ControllerAdvice
public class GlobalExceptionAspect {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionAspect.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result processMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Result result = new Result(null);
        result.setCode(PARAM_INVALID_ERROR.getCode());
        List<String> detail = new ArrayList<>();
        detail.add(e.getParameter().getParameterName() + " invalid");
        result.setMessage(StringUtils.join(detail, ","));
        log.error("GlobalExceptionAspect MethodArgumentNotValidException", e);
        return result;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result processThrowable(Throwable t) {
        log.error("GlobalExceptionAspect Throwable", t);
        if (t instanceof BusinessException) {
            return Result.error(((BusinessException)t).getErrorCode(), t.getMessage());
        }
        return Result.error(UNKNOWN_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Result processHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("GlobalExceptionAspect HttpMessageNotReadableException", e);
        return Result.error(PARAM_INVALID_ERROR);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Result processMissingServletRequestParameterException(HttpServletRequest request, MissingServletRequestParameterException e) {
        log.error("GlobalExceptionAspect MissingServletRequestParameterException: path: {}, user: {}, addr: {}, host: {}",
                request.getServletPath(),
                request.getRemoteUser(),
                request.getRemoteAddr(),
                request.getRemoteHost(),
                e);
        return Result.error(PARAM_INVALID_ERROR);
    }

}
