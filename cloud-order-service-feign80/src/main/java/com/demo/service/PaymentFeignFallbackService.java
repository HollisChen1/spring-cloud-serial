package com.demo.service;

import com.demo.base.ApiResult;
import com.demo.domain.Payment;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/28 23:13
 */
public class PaymentFeignFallbackService implements PaymentFeignService {
    @Override
    public ApiResult<Integer> create(Payment payment) {
        return ApiResult.success(-1);
    }

    @Override
    public ApiResult<String> timeout(Integer id) {
        return ApiResult.success("降级啦");
    }
}
