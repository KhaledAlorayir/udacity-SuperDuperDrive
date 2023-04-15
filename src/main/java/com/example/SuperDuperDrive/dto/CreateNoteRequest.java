package com.example.SuperDuperDrive.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteRequest {
    private Integer id;

    @NotBlank
    @Size(max = 20)
    private String title;
    @NotBlank
    @Size(max = 1000)
    private String description;

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }
}
