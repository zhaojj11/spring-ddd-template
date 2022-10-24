package com.zhaojj11.template.demo.config.handler;

import com.zhaojj11.template.common.model.vo.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author zhaojj11
 */
@RequiredArgsConstructor
public class ResultWarpReturnValueHandler implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler returnValueHandler;

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return this.returnValueHandler.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        // 判断外层是否有APiResult包裹
        if (returnValue instanceof ApiResult) {
            this.returnValueHandler.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
            return;
        }
        this.returnValueHandler.handleReturnValue(ApiResult.ok(returnValue), returnType, mavContainer, webRequest);
    }
}
