package com.example.msg.controller;

import com.example.msg.dto.AddQuestionRequest;
import com.example.msg.dto.QuestionResponse;
import com.example.msg.domain.Question;
import com.example.msg.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Object> addQuestion(@RequestBody AddQuestionRequest dto) {
        Question created = questionService.create(dto);
        System.out.println(created.toString());

        if (created != null) {
            QuestionResponse response = new QuestionResponse("질문이 등록되었습니다.");
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
