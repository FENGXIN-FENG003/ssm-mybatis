package com.fengxin.mapper;

import com.fengxin.pojo.User;

/**
* @author FENGXIN
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-08-02 13:14:39
* @Entity com.fengxin.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
