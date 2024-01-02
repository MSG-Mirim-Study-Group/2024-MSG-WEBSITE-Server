package com.example.msg.controller;

import com.example.msg.dto.AddQuestionRequest;
import com.example.msg.dto.QuestionResponse;
import com.example.msg.domain.Question;
import com.example.msg.exception.QnaException;
import com.example.msg.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    // POST
    @PostMapping
    public ResponseEntity<Object> addQuestion(@RequestBody AddQuestionRequest dto) {
        try {
            Question created = questionService.create(dto);
            System.out.println(created.toString());

            QuestionResponse response = new QuestionResponse("질문이 등록되었습니다.");
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
        } catch (QnaException e) {
            // 예외가 발생하면 예외 메시지를 JSON 형태로 반환
            QuestionResponse errorResponse = new QuestionResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
        }
    }

    // GET
    @GetMapping
    public List<Question> questionList() {
        return questionService.list();
    }
}
