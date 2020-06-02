package com.afei.springcloud.dao;
import com.afei.springcloud.entities.PaymentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-01 23:27:06
 */
@Mapper
public interface PaymentDao extends BaseMapper<PaymentEntity> {
	
}
