package com.example.SuperDuperDrive.mapper;

import com.example.SuperDuperDrive.dto.CreateNoteRequest;
import com.example.SuperDuperDrive.entity.Credential;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CredentialMapper {
    @Insert("INSERT INTO credentials(url,username,secret,password,user_id) VALUES(#{url},#{username},#{secret},#{password},#{user_id})")
    void create(Credential credential);

    @Select("SELECT * FROM credentials WHERE user_id = #{userId}")
    List<Credential> findAllByUserId(int userId);

    @Select("SELECT * FROM credentials WHERE id = #{credentialId}")
    Optional<Credential> findById(int credentialId);

    @Delete("DELETE FROM credentials WHERE id = #{credentialId}")
    void deleteById(int credentialId);
    @Update("UPDATE credentials SET url=#{url},username=#{username},password=#{password},secret=#{secret} WHERE id = #{id}")
    void updateById(Credential credential);
}