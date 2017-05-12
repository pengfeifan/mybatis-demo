package com.github.demo.mapper;

import com.github.demo.model.UserModel;

import java.util.List;

public interface UserModelMapper {
    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(Integer userId);

    List<UserModel> selectAllWithPagination(Integer offset,Integer rows);
}