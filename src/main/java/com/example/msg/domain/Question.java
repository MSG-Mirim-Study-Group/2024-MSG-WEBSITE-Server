package com.example.msg.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor // Question() 생성자 대체
@NoArgsConstructor // 기본 생성자 추가
@ToString
@Entity // 엔티티 선언
@Getter // 게터 추가
@Setter
@Table(name = "qna")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;
    @Column
    private String answer;

    @JsonIgnore
    public Long getId() {
        return id;
    }


}
