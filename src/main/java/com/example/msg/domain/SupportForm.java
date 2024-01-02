package com.example.msg.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "support-form")
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

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "strengths")
    private String strengths;

    @Column(name = "failure")
    private String failure;

    @Column(name = "question")
    private String question;

    @Column(name = "definition")
    private String definition;

    @Builder
    public SupportForm(
            long id,
            String name,
            String studentId,
            String tel,
            String email,
            String purpose,
            String strengths,
            String failure,
            String question,
            String definition) {
        this.id = id;
        this.name = name;
        this. studentId = studentId;
        this.tel = tel;
        this.email = email;
        this.purpose = purpose;
        this.strengths = strengths;
        this.failure = failure;
        this.question = question;
        this.definition = definition;
    }
}
