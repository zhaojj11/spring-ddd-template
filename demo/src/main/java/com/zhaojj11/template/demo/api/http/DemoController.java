package com.zhaojj11.template.demo.api.http;

import com.zhaojj11.template.common.model.vo.ApiResult;
import com.zhaojj11.template.demo.common.constants.Constants;
import com.zhaojj11.template.demo.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/test/return")
    public Map<String, String> testReturnValue() {
        return Map.of("msg", Constants.OK);
    }

    @GetMapping("/test/exception/{key}")
    public ApiResult<Object> testException(@PathVariable Integer key) {
        if (key == 1) {
            throw new BizException(4000, "biz exception");
        }
        log.info(String.valueOf(key));
        return ApiResult.ok(Map.of("msg", key));
    }
}
