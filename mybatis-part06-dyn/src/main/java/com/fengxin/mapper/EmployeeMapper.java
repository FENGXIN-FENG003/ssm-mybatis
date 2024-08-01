package com.fengxin.mapper;

import com.fengxin.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/7/30
 **/
public interface EmployeeMapper {
    List<Employee> query(@Param (value = "empName") String name,@Param (value = "empSalary") Double salary);
}
