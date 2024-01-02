package com.example.msg.repository;

import com.example.msg.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Override
    ArrayList<Question> findAll();
}
