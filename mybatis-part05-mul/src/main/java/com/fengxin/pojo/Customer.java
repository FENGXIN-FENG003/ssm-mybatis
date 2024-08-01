package com.fengxin.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/8/1
 **/
@Data
public class Customer {
    private int customerId;
    private String customerName;
    // 对多映射
    private List<Order> orderList;
}
