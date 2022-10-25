package com.zhaojj11.template.demo.exception;

/**
 * @author zhaojunjie
 */
public class BizException extends BaseException {
    public BizException(String message) {
        super(message);
    }

    public BizException(Integer code, String message) {
        super(code, message);
    }
}
