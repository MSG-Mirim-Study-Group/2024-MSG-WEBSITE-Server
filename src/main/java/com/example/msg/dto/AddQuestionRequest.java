package com.example.msg.dto;

// 질문 등록 - post

import com.example.msg.domain.Question;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString(includeFieldNames = false)
@NoArgsConstructor
@AllArgsConstructor
public class AddQuestionRequest {
    private String question;
    private String answer;

    public Question toEntity() {
        return new Question(null, question, answer);
    }

}
