package com.generator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generator.model.Difficulty;
import com.generator.model.Question;

//QuestionRepository.java
public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findByDifficulty(Difficulty difficulty);
}
