package com.demo.base;

import com.demo.base.enums.ApiResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ApiResult<T> {

    private Integer code;

    private String msg;

    private T data;

    public static <T> ApiResult<T> success() {
        return fromEnum(ApiResultEnum.SUCCESS);
    }

    public static <T> ApiResult<T> success(T data) {
        return fromEnum(ApiResultEnum.SUCCESS).setData(data);
    }

    private static ApiResult fromEnum(ApiResultEnum resultEnum) {
        return new ApiResult()
                .setCode(resultEnum.getCode())
                .setMsg(resultEnum.getMsg());
    }

}
