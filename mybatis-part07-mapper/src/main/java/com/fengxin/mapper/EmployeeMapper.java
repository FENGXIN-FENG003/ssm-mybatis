package com.fengxin.mapper;

import com.fengxin.pojo.Employee;

/**
 * @author FENGXIN
 * @date 2024/7/30
 **/
public interface EmployeeMapper {
    Employee queryById(Integer id);
}
