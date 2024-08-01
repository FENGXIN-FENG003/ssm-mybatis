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
    List<Employee> queryTrim(@Param (value = "empName") String name,@Param (value = "empSalary") Double salary);
    List<Employee> queryChoose(@Param (value = "empName") String name,@Param (value = "empSalary") Double salary);
    
    int update(Employee employee);
    
    // 批量
    List<Employee> queryBacth(List<Integer> ids);
    List<Integer> deleteBacth(List<Integer> ids);
    int insertBacth(List<Employee> employees);
    int updateBacth(List<Employee> employees);
    
    
}
