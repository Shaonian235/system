package com.kyh.system.mapper;

import com.kyh.system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    // 查询全部用户
    List<User> selectAllUser();
    /***
     * 用户登录
     */
    User selectselectByKeyAndPassword(User user);
    int getUsernumber();
}