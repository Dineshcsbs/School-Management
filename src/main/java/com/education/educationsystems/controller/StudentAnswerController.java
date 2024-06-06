package com.education.educationsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.entity.StudentAnswer;
import com.education.educationsystems.service.StudentAnswerService;

import jakarta.persistence.ManyToOne;

@RestController
@RequestMapping("/api/student-answer")
public class StudentAnswerController {

	@Autowired
	private StudentAnswerService studentAnswerService;
	@PostMapping("/")
	public StudentAnswer createRecord(@RequestBody StudentAnswer studentAnswer) {
		return studentAnswerService.createRecord(studentAnswer);
	}
}
