package com.example.DemoTestContainers.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class BookDTO {
    private Long id;
    @NotBlank(message = "title Should not be empty")
    private String title;
    @NotEmpty(message = "Author Should not be empty")
    private String author;


}
