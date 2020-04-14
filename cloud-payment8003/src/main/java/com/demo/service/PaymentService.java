package com.demo.service;

import com.demo.dao.PaymentMapper;
import com.demo.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    public Integer create(Payment payment){
        return paymentMapper.create(payment);
    }

    public Payment get(Integer id){
        return paymentMapper.get(id);
    }
}
