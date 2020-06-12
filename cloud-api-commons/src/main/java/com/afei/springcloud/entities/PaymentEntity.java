package com.afei.springcloud.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@TableName("payment")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    private String serial;

}
