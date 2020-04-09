package com.demo.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiResultEnum {
    SUCCESS(200,"成功"),
    PARAMETER_ERROR(401,"参数错误"),
    SYSTEM_ERROR(999,"系统异常")
    ;

    private Integer code;

    private String msg;


}
