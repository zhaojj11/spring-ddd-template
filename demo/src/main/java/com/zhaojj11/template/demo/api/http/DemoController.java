package com.zhaojj11.template.demo.api.http;

import com.zhaojj11.template.common.model.vo.ApiResult;
import com.zhaojj11.template.demo.common.constants.Constants;
import com.zhaojj11.template.demo.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhaojj11
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    public ApiResult<Object> test() {
        return ApiResult.ok(Map.of("msg", Constants.OK));
    }

    @GetMapping("/test/exception")
    public ApiResult<Object> testException() {
        int i = 1 / 0;
        log.info(String.valueOf(i));
        return ApiResult.ok(Map.of("msg", Constants.OK));
    }

    @GetMapping("/test/base-exception")
    public ApiResult<Object> testCatchException() {
        try {
            int i = 1 / 0;
            log.info(String.valueOf(i));
        } catch (Exception e) {
            throw new BaseException("base exception");
        }
        return ApiResult.ok(Map.of("msg", Constants.OK));
    }
}
