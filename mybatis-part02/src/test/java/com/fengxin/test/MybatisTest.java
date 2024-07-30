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
 * @date 2024/7/30
 **/
public class MybatisTest {
    @Test
    public void test01() throws IOException {
        // 配置流
        InputStream is = Resources.getResourceAsStream ("mybatis/MybatisConfig.xml");
        // 工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ().build (is);
        // 会话
        SqlSession session = sqlSessionFactory.openSession ();
        // 映射
        EmployeeMapper employeeMapper = session.getMapper (EmployeeMapper.class);
        // 根据代理对象调用方法
        Employee employee = employeeMapper.queryById (1);
        System.out.println ("employee = " + employee);
        // 关闭
        session.close ();
    }
    
}
