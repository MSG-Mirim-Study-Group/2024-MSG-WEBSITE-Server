package com.example.msg.dto;

// 지원서 등록 - post

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddSupportFormRequest {
    private long id;
    private String name;
    private String studentId;
    private String tel;
    private String email;
    private String purpose;
    private String strengths;
    private String failure;
    private String question;
    private String definition;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
