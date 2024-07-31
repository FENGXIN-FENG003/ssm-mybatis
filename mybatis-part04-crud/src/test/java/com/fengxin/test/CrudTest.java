package com.fengxin.test;

import com.fengxin.mapper.UserMapper;
import com.fengxin.pojo.User;
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

/**
 * @author FENGXIN
 * @date 2024/7/31
 **/
public class CrudTest {
    private SqlSession session;
    @BeforeEach
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream ("mybatis/MybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ().build (is);
        session = sqlSessionFactory.openSession (true);
    }
    @AfterEach
    public void after(){
        session.close ();
    }
    @Test
    public void insertTest() {
        User user = new User();
        user.setUsername("admin2");
        user.setPassword("123456");
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.insert(user);
        System.out.println(user);
    }
    
    @Test
    public void updateTest() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectById(1);
        user.setUsername("root");
        user.setPassword("111111");
        userMapper.update(user);
        user = userMapper.selectById(1);
        System.out.println(user);
    }
    
    @Test
    public void deleteTest() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.delete(1);
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
    }
    
    @Test
    public void selectByIdTest() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
    }
    
    @Test
    public void selectAllTest() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAll();
        System.out.println("userList = " + userList);
    }
}
