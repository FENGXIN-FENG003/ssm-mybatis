package com.fengxin;/**
 * @author FENGXIN
 * @date 2024/8/1
 * @project ssm-mybatis-part
 **/

import com.fengxin.mapper.EmployeeMapper;
import com.fengxin.pojo.Employee;
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

public class DynTest {
    private SqlSession session;
    
    @BeforeEach
    public void before () throws IOException {
        InputStream is = Resources.getResourceAsStream ("mybatis/MybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ().build (is);
        session = sqlSessionFactory.openSession (true);
    }
    
    @Test
    public void whereAndIf(){
        List<Employee> list = session.getMapper (EmployeeMapper.class).query (null,777.77);
        System.out.println ("list = " + list);
    }
    
    @AfterEach
    public void after () {
        session.close ();
    }
}