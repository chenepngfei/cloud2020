package com.afei.springcloud.service;

import com.afei.springcloud.entities.PaymentEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-01 23:27:06
 */
public interface PaymentService extends IService<PaymentEntity> {
    public  int create(PaymentEntity paymentEntity);
    public PaymentEntity getPaymentById(@Param("id") Long id);
}


