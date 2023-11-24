package com.generator.service;

import java.util.List;

import com.generator.model.Difficulty;
import com.generator.model.Question;

public interface QuestionService {
	
	List<Question> getQuestionsByDifficultyAndMarks(Difficulty string, Integer currMarks, Integer totalmarks);

	void saveQuestion(List<Question> question);

	
}
