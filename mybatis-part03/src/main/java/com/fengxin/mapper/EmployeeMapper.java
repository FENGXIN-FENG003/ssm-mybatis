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
    Employee queryEmpById(Integer id);
    Double querySalaryById(Integer id);
    
}
