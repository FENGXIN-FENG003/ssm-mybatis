package com.fengxin.pojo;

import lombok.Data;

/**
 * @author FENGXIN
 * @date 2024/8/1
 **/
@Data
public class Order {
    private int orderId;
    private String orderName;
    private Customer customer;
}