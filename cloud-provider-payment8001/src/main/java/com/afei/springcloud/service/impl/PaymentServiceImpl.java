package com.afei.springcloud.service.impl;

import com.afei.springcloud.dao.PaymentDao;
import com.afei.springcloud.entities.PaymentEntity;
import com.afei.springcloud.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;



@Service("paymentService")
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, PaymentEntity> implements PaymentService {

    @Override
    public int create(PaymentEntity paymentEntity) {
        return 0;
    }

    @Override
    public PaymentEntity getPaymentById(Long id) {
        return null;
    }
}
