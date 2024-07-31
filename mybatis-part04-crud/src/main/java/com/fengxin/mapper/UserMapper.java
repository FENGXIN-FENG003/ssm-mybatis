package com.fengxin.mapper;

import com.fengxin.pojo.User;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/7/31
 **/
public interface UserMapper {
    int insert(User user);
    
    int update(User user);
    
    int delete(Integer id);
    
    User selectById(Integer id);
    
    List<User> selectAll();
}
