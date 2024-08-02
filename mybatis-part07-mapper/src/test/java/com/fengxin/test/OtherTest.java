package com.fengxin.test;/**
 * @author FENGXIN
 * @date 2024/8/2
 * @project ssm-mybatis-part
 **/

import com.fengxin.mapper.EmployeeMapper;
import com.fengxin.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OtherTest {
    private SqlSession session;
    
    @BeforeEach
    public void before () throws IOException {
        InputStream is = Resources.getResourceAsStream ("mybatis/MybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ().build (is);
        session = sqlSessionFactory.openSession (true);
    }
    
    @Test
    public void pageTest(){
        EmployeeMapper employeeMapper = session.getMapper (EmployeeMapper.class);
        // 在执行sql语句前配置pagehelper
        // 当前页 页数据量
        PageHelper.startPage (1,2);
        List<Employee> list = employeeMapper.query ();
        // 使用pageInfo实体对象存储数据
        PageInfo<Employee> pageInfo = new PageInfo<> (list);
        // 调用pageInfo相关方法
        System.out.println (pageInfo.getPages ());
        System.out.println (pageInfo.getPageNum ());
        System.out.println (pageInfo.getPageSize ());
        
    }
    
    @AfterEach
    public void after () {
        session.close ();
    }
}