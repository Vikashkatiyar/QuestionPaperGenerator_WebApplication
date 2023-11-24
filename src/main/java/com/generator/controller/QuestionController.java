package com.generator.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generator.model.Difficulty;
import com.generator.model.Question;
import com.generator.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	
	@GetMapping("/generate-paper")
	public ResponseEntity<List<Question>> generateQuestionPaper(@RequestBody Map<String, Integer> requestData) {

		// Extract data from the JSON request
		int totalMarks = requestData.get("totalMarks");
		int easyMarks = requestData.get("easy");
		int mediumMarks = requestData.get("medium");
		int hardMarks = requestData.get("hard");

		if (totalMarks < 5 || totalMarks > 300 || totalMarks % 5 != 0 || easyMarks < 0 || mediumMarks < 0
				|| hardMarks < 0 || easyMarks + mediumMarks + hardMarks != totalMarks) {
			return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
		}

		List<Question> generatedPaper = new ArrayList<>();
		generatedPaper.addAll(questionService.getQuestionsByDifficultyAndMarks(Difficulty.EASY, easyMarks, totalMarks));
		generatedPaper
				.addAll(questionService.getQuestionsByDifficultyAndMarks(Difficulty.MEDIUM, mediumMarks, totalMarks));
		generatedPaper.addAll(questionService.getQuestionsByDifficultyAndMarks(Difficulty.HARD, hardMarks, totalMarks));

		return new ResponseEntity<>(generatedPaper, HttpStatus.OK);
	}

	@PostMapping("/post")
	public ResponseEntity<String> postQuestion(@RequestBody List<Question> question) {
		try {
			questionService.saveQuestion(question);
			return new ResponseEntity<>("Question saved successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Error saving the question: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
