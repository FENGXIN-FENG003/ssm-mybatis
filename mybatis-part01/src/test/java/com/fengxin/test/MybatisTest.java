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
        // 1.以输入流的形式加载Mybatis配置文件
        InputStream is = Resources.getResourceAsStream("mybatis/MybatisConfig.xml");
        // 2.基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder ().build (is);
        // 3.使用SqlSessionFactory对象开启一个会话
        SqlSession session = sessionFactory.openSession ();
        // 4.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
        EmployeeMapper employeeMapper = session.getMapper (EmployeeMapper.class);
        // 5.调用代理类方法既可以触发对应的SQL语句
        Employee employee = employeeMapper.queryById (1);
        System.out.println ("employee = " + employee);
        // 6.关闭SqlSession
        session.close ();
    }
}
