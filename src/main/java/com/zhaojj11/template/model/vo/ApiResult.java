package com.zhaojj11.template.model.vo;

import com.zhaojj11.template.constants.StringConstant;
import com.zhaojj11.template.enums.ApiResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaojj11
 */

@Data
@Builder
@AllArgsConstructor
public class ApiResult<T> implements Serializable {
    private boolean success;
    private Integer code;
    private String msg;
    private T data;

    public static <T> ApiResult<T> ok(){
        return new ApiResult<T>(true, ApiResultCodeEnum.SUCCESS.getCode(), StringConstant.OK, null);
    }

    public static <T> ApiResult<T> ok(T data){
        return new ApiResult<T>(true, ApiResultCodeEnum.SUCCESS.getCode(), StringConstant.OK, data);
    }

    public static <T> ApiResult<T> fail(String msg){
        return new ApiResult<T>(false, ApiResultCodeEnum.FAILED.getCode(), msg, null);
    }
}
