package com.example.msg.service;

import com.example.msg.dto.AddQuestionRequest;
import com.example.msg.domain.Question;
import com.example.msg.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Slf4j // 로깅
@Service // 서비스
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    // 주어진 AddQuestionRequest를 이용하여 질문을 생성하고 저장
    @Transactional
    public Question create(AddQuestionRequest dto) {
        Question question = dto.toEntity();
        log.info(dto.toString());
        return questionRepository.save(question);
    }

    // 현재 저장된 모든 질문 목록을 조회
    @Transactional(readOnly = true)
    public ArrayList<Question> list() {
        return questionRepository.findAll();
    }
}
