package com.education.educationsystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.DTO.QuestionDTO;
import com.education.educationsystems.entity.Question;
import com.education.educationsystems.service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/")
	public Question createQuestion(@RequestBody Question question) {
		return questionService.createQuestion(question);
	}
	
	@GetMapping("/view/{id}")
	public List<QuestionDTO> displayQuestion(@PathVariable Long id){
		return questionService.displayQuestion(id);
	}
	
	@GetMapping("/page")
	public Page<QuestionDTO> pageConcept(@RequestParam(defaultValue="0") int  offSet,@RequestParam(defaultValue="5") int pageSize,@RequestParam(defaultValue="id")String fieldName,@RequestParam(defaultValue="ASC")Direction direction){
		return questionService.pageConcept(offSet,pageSize,fieldName, direction);
	}
}
