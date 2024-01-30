package com.example.msg.controller;

import com.example.msg.domain.SupportForm;
import com.example.msg.dto.AddSupportFormRequest;
import com.example.msg.service.SupportFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/support-form")
public class SupportFormController {
    private final SupportFormService supportFormService;

    @PostMapping
    public ResponseEntity<SupportForm> addSupportForm(@RequestBody AddSupportFormRequest request) {
        SupportForm savedSupportForm = supportFormService.save(request);

        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedSupportForm);
    }
}
