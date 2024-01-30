package com.example.msg.service;

import com.example.msg.domain.SupportForm;
import com.example.msg.dto.AddSupportFormRequest;
import com.example.msg.repository.SupportFormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SupportFormService {

    private final SupportFormRepository supportFormRepository;

    public SupportForm save(AddSupportFormRequest request) {
        return supportFormRepository.save(request.toEntity());
    }

    public List<SupportForm> findAll() {
        return supportFormRepository.findAll();
    }

}
