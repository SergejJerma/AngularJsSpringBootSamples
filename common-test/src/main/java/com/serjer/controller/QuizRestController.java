package com.serjer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serjer.model.Answer;
import com.serjer.model.Item;
import com.serjer.model.Question;
import com.serjer.repo.ResultsRepo;
import com.serjer.service.FileReadingService;

@RestController
@RequestMapping("/api/quiz")
public class QuizRestController {

	@Autowired
	private FileReadingService fileReadingService;
	
	@Autowired
	private ResultsRepo resultsRepo;

	@GetMapping
	public List<Item> getAllEmployees() {
		return fileReadingService.readingJsonFile();
	}
	
	@PostMapping
    public void saveResults(@RequestBody List<Item> results) {
		results.stream()
			   .forEach((e)->resultsRepo.save(new Question(e.getQuestion(),
					   									  new Answer(e.getAnswers().get(0)))));
    }
}