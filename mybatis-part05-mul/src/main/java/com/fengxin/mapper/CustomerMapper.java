package com.fengxin.mapper;

import com.fengxin.pojo.Customer;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/8/1
 **/
public interface CustomerMapper {
    List<Customer> queryCustomerAll();
}
