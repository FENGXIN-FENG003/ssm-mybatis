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
    
    /**
     * 返回查询结果的map
     * 适用于SQL查询返回的各个字段综合起来并不和任何一个现有的实体类对应，没法封装到实体类对象中。
     * 能够封装成实体类类型的，就不使用Map类型
     * @return map
     */
    Map<String,Object> selectEmpNameAndMaxSalary();
    
    /**
     * 插入员工数据 并进行主键回显
     * @return int
     */
    int insertEmp(Employee employee);
}
