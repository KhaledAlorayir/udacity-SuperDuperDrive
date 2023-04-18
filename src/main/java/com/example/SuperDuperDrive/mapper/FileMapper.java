package com.example.SuperDuperDrive.mapper;

import com.example.SuperDuperDrive.entity.File;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FileMapper {
    @Select("SELECT * FROM files WHERE user_id = #{userId} AND name = #{filename}")
    Optional<File> findByFilenameAndUserId(String filename, int userId);

    @Insert("INSERT INTO files(name,content_type,file_size,user_id,file_data) VALUES(#{name},#{content_type},#{file_size},#{user_id},#{file_data})")
    void create(File file);

    @Select("SELECT * FROM files WHERE id = #{fileId}")
    Optional<File> findById(int fileId);

    @Select("SELECT id,name,content_type,file_size FROM files WHERE user_id = #{userId}")
    List<File> findAllByUserId(int userId);

    @Delete("DELETE FROM files WHERE id = ${fileId}")
    void deleteById(int fileId);
}