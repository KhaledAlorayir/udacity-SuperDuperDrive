package com.example.SuperDuperDrive.mapper;

import com.example.SuperDuperDrive.dto.CreateNoteRequest;
import com.example.SuperDuperDrive.entity.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NoteMapper {
    @Insert("INSERT INTO notes(title,description,user_id) VALUES(#{title},#{description},#{user_id})")
    void create(Note note);

    @Select("SELECT * FROM notes WHERE user_id = #{userId}")
    List<Note> findAllByUserId(int userId);

    @Delete("DELETE FROM notes WHERE id = #{noteId}")
    void deleteById(int noteId);

    @Select("SELECT * FROM notes where id = #{noteId}")
    Optional<Note> findById(int noteId);

    @Update("UPDATE notes SET title=#{title},description=#{description} WHERE id = #{id}")
    void updateById(CreateNoteRequest note);

}
