package com.example.msg.service;

import com.example.msg.dto.AddQuestionRequest;
import com.example.msg.domain.Question;
import com.example.msg.exception.QnaErrorCode;
import com.example.msg.exception.QnaException;
import com.example.msg.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;


@SpringBootTest
class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @Test
    void testCreateQuestion() {
        // 테스트용 데이터 생성
        AddQuestionRequest request = new AddQuestionRequest();
        request.setQuestion("Test Question");

        // Mock repository 설정
        when(questionRepository.save(any(Question.class))).thenAnswer(invocation -> {
            Question savedQuestion = invocation.getArgument(0);
            savedQuestion.setId(1L); // Mock id 할당
            return savedQuestion;
        });

        // 테스트 메소드 호출
        Question createdQuestion = questionService.create(request);

        // 결과 확인
        assertNotNull(createdQuestion);
        assertEquals(1L, createdQuestion.getId());
        assertEquals("Test Question", createdQuestion.getQuestion());

        // Mock repository의 save 메소드가 1번 호출되었는지 확인
        verify(questionRepository, times(1)).save(any(Question.class));
    }

    @Test
    void testCreateQuestionWithInvalidInput() {
        // 테스트용 데이터 생성 (빈 질문)
        AddQuestionRequest request = new AddQuestionRequest();
        request.setQuestion("");

        // 예외가 발생하는지 확인
        QnaException exception = assertThrows(QnaException.class, () -> {
            questionService.create(request);
        });

        // 예외 코드 확인
        assertEquals(QnaErrorCode.NO_QUESTION, exception.getErrorCode());

        // Mock repository의 save 메소드가 호출되지 않았는지 확인
        verify(questionRepository, never()).save(any(Question.class));
    }

    @Test
    void testListQuestions() {
        // Mock repository 설정
        when(questionRepository.findAll()).thenReturn(new ArrayList<>());

        // 테스트 메소드 호출
        ArrayList<Question> questionList = questionService.list();

        // 결과 확인
        assertNotNull(questionList);
        assertTrue(questionList.isEmpty());

        // Mock repository의 findAll 메소드가 1번 호출되었는지 확인
        verify(questionRepository, times(1)).findAll();
    }
}