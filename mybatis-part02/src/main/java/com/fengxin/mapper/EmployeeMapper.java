package com.fengxin.mapper;

import com.fengxin.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author FENGXIN
 * @date 2024/7/30
 **/
public interface EmployeeMapper {
    // 方法不允许重载 方法名 = id 会冲突
    Employee queryById(Integer id);
    // 增删改返回值都是int 影响结果行数
    // 1.简单类型传入 Integer int String 单值 #{名随意}
    int deleteById(Integer id);
    List<Employee> queryBySalary(Double salary);
    
    // 2.实体类型传入 Employee #{类中属性}
    int insertEmp(Employee employee);
    
    // 3.零散简单类型传入 #{@param(value)}
    Employee queryByIdAndSalary(@Param ("a") Integer id,@Param ("b") Double salary);
    
    // 4.map类型传入 #{map的key}
    int insertEmpMap(Map<String,Double> data);
}
