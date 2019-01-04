package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	User getUserById(@Param("id") int id);
}
