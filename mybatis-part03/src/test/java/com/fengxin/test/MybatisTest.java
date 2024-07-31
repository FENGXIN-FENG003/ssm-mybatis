package com.fengxin.test;

import com.fengxin.mapper.EmployeeMapper;
import com.fengxin.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FENGXIN
 * @date 2024/7/31
 **/
public class MybatisTest {
    /**
     * 插入数据 主键回显 主键自增
     */
    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream ("mybatis/MybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ().build (resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession ();
        Employee employee = new Employee ();
        employee.setEmpName ("枫");
        employee.setEmpSalary (10000.0);
        EmployeeMapper employeeMapper = session.getMapper (EmployeeMapper.class);
        int rows = employeeMapper.insertEmp (employee);
        System.out.println ("rows = " + rows);
        System.out.println ("empId = " + employee.getEmpId ());
        // DML需要提交事务才能修改数据库的数据
        session.commit ();
        session.close ();
    }
    
}
