package com.kyh.system.Impl;

import com.github.pagehelper.PageHelper;
import com.kyh.system.entity.User;
import com.kyh.system.mapper.UserMapper;
import com.kyh.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    //注入调用数据库操作mapper
    @Autowired
    private UserMapper userMapper;// 出现编译报错 不影响 去掉方法   可以在settings里面的spring bean中设置一下
    /**
     * 添加用户
     * */
    @Override
    public int addUser(User user){
     return  userMapper.insertSelective(user);
    }
    /***
     * 分页查询
     * */
   @Override
    public List<User> findAllUser(int pageNum, int pageSize){
       PageHelper.startPage(pageNum, pageSize);
       return userMapper.selectAllUser();
   }
    /***
     * 通过id 删除用户
     *
     */
   @Override
    public int delete(int key){

       return  userMapper.deleteByPrimaryKey(key);
   }
    /***
     *
     * 修改用户
     */
   @Override
    public int update(User user){
       return userMapper.updateByPrimaryKeySelective(user);
   }

   /**
    * 用户登录
    * */
   public User getUserById(User user){

       return userMapper.selectselectByKeyAndPassword(user);
   };

    @Override
    public int getUsernumber(){
        return userMapper.getUsernumber();
    }

}
