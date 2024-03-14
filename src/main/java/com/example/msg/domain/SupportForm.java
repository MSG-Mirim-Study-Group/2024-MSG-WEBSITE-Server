package com.example.msg.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@AllArgsConstructor // Question() 생성자 대체
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Builder
@Table(name = "support_form")
public class SupportForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "studentId")
    private String studentId;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email")
    private String email;

    @Column(name = "purpose", length = 200000)
    private String purpose;

    @Column(name = "strengths", length = 200000)
    private String strengths;

    @Column(name = "failure", length = 200000)
    private String failure;

    @Column(name = "question", length = 1000)
    private String question;

    @Column(name = "definition")
    private String definition;

    @Column(name = "createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public long getId() {
        return id;
    }
}
