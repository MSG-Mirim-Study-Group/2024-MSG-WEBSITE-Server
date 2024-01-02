package com.example.msg.service;

import com.example.msg.dto.AddQuestionRequest;
import com.example.msg.domain.Question;
import com.example.msg.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question create(AddQuestionRequest dto) {
        Question question = dto.toEntity();
        System.out.println(dto.toEntity());
        log.info(dto.toString());
        return questionRepository.save(question);
    }
}
