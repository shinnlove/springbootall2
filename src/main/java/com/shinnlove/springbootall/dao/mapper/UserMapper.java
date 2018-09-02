package com.shinnlove.springbootall.dao.mapper;

import java.util.List;

import com.shinnlove.springbootall.model.User;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询所有用户。
     *
     * @return
     */
    List<User> selectAllUser();

}