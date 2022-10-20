package com.zhaojj11.template.demo.exception;

import com.zhaojj11.template.common.model.vo.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author zhaojj11
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 算数异常
     *
     * @param e 算数异常
     * @return api 返回
     */
    @ExceptionHandler({ArithmeticException.class})
    public ApiResult<Object> arithmeticException(ArithmeticException e) {
        log.error("ArithmeticException:", e);
        return ApiResult.fail("算数错误");
    }

    @ExceptionHandler({BaseException.class})
    public ApiResult<Object> baseException(BaseException e) {
        log.error("BaseException:", e);
        return ApiResult.fail("BaseException");
    }
}
