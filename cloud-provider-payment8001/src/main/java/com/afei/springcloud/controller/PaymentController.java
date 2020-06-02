package com.afei.springcloud.controller;

import com.afei.springcloud.entities.CommonResult;
import com.afei.springcloud.entities.PaymentEntity;
import com.afei.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-01 23:27:06
 */
@RestController
@RequestMapping("sys/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 列表
     * @return
     */
    @RequestMapping("/list")
    public CommonResult<List<PaymentEntity>> list(@RequestParam Map<String, Object> params){

        List<PaymentEntity> list = paymentService.list();
        return new CommonResult<List<PaymentEntity>>(200, "查询成功", list);

    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<PaymentEntity> getPaymentById(@PathVariable("id") Long id){

        PaymentEntity paymentEntity = paymentService.getById(id);

        if(paymentEntity != null){
            return new CommonResult<>(200,"查询成功",paymentEntity);
        }else{
            return new  CommonResult<>(444,"查询失败",null);
        }

    }



    /**
     * 保存
     */
    @RequestMapping("/save")
    public CommonResult<PaymentEntity> save(@RequestBody PaymentEntity payment) {
       // PaymentEntity payment = new PaymentEntity();
       // payment.setSerial("sdfdsfs");
        paymentService.save(payment);

        log.info("插入结果：",payment + "hehe");
        if(payment.getId() > 0){
            return  new CommonResult(200,"插入数据库成功",payment.getId());
        }else{
            return  new CommonResult<>(444,"插入数据库失败",null);
        }

        //return new CommonResult<PaymentEntity>(1,payment.getId().toString());
    }


}
