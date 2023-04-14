package com.example.SuperDuperDrive.mapper;

import com.example.SuperDuperDrive.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS")
    List<User> getAll();
    @Insert("INSERT INTO users(username,salt,password,firstname,lastname) VALUES(#{username},#{salt},#{password},#{firstname},#{lastname})")
    void create(User user);

}
