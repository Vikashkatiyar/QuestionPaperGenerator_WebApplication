package com.generator.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generator.model.Difficulty;
import com.generator.model.Question;
import com.generator.repository.QuestionRepository;

import jakarta.transaction.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> getQuestionsByDifficultyAndMarks(Difficulty difficulty, Integer currMarks,
			Integer totalmarks) {
		List<Question> answer = new ArrayList<Question>();

		Integer thresholdAmount = getAmountByDifficulty(difficulty);
		List<Question> questionList = questionRepository.findByDifficulty(difficulty);

		int questionCount = (int) ((currMarks / 100.0) * totalmarks);

		int i = -1;
		while (questionCount >= thresholdAmount) {
			++i;
			if (i >= questionList.size()) {
				break;
			}

			answer.add(questionList.get(i));
			questionCount -= thresholdAmount;

		}
		return answer;

	}

	public Integer getAmountByDifficulty(Difficulty difficulty) {

		int amount = -1;
		if (difficulty.equals(Difficulty.EASY)) {
			amount = 5;
		} else if (difficulty.equals(Difficulty.MEDIUM)) {
			amount = 10;
		} else {
			amount = 15;
		}

		return amount;
	}

	@Override
	@Transactional
	public void saveQuestion(List<Question> questions) {

		Iterator<Question> it = questions.iterator();
		while (it.hasNext()) {
			questionRepository.save(it.next());
		}

	}

}
