package com.example.SuperDuperDrive.mapper;

import com.example.SuperDuperDrive.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE UPPER(username) = #{username}")
    Optional<User> findByUsername(String username);
    @Insert("INSERT INTO users(username,salt,password,firstname,lastname) VALUES(#{username},#{salt},#{password},#{firstname},#{lastname})")
    void create(User user);

}
