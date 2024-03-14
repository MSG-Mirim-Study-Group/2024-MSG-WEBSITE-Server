package com.example.msg.service;

import com.example.msg.domain.SupportForm;
import com.example.msg.dto.AddSupportFormRequest;
import com.example.msg.repository.SupportFormRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SupportFormService {

    private final SupportFormRepository supportFormRepository;

    public SupportForm save(AddSupportFormRequest request) {
        log.info(request.toString());
        return supportFormRepository.save(request.toEntity());
    }

    public List<SupportForm> findAll() {
        return supportFormRepository.findAll();
    }

}
