package com.zhaojj11.template.demo.api.http;

import com.zhaojj11.template.common.model.vo.ApiResult;
import com.zhaojj11.template.demo.common.constants.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhaojj11
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    public ApiResult<Object> test(){
        return ApiResult.ok(Map.of("msg", Constants.OK));
    }
}
