package com.example.SuperDuperDrive.mapper;

import com.example.SuperDuperDrive.entity.Credential;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CredentialMapper {
    @Insert("INSERT INTO credentialS(url,username,secret,password,user_id) VALUES(#{url},#{username},#{secret},#{password},#{user_id})")
    void create(Credential credential);
}