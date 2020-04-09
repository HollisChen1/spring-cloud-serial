package com.demo.dao;

import com.demo.domain.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PaymentMapper {

    @Insert("insert into payment (order_no) values (#{payment.orderNo})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer create(@Param("payment") Payment payment);

    @Select("select * from payment where id = #{id}")
    Payment get(Integer id);

}
