package com.example.SuperDuperDrive.mapper;

import com.example.SuperDuperDrive.entity.Note;
import com.example.SuperDuperDrive.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Insert("INSERT INTO notes(title,description,user_id) VALUES(#{title},#{description},#{userId})")
    void create(Note note);

    @Select("SELECT * FROM notes WHERE user_id = ${userId}")
    List<Note> findAllByUserId(int userId);
}
