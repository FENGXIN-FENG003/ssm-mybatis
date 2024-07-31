package com.fengxin.mapper;

import com.fengxin.pojo.Teacher;

/**
 * @author FENGXIN
 * @date 2024/7/31
 **/
public interface TeacherMapper {
    int insertTea(Teacher teacher);
    Teacher queryNameById(String id);
}
