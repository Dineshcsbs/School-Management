package com.education.educationsystems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.StudentAnswer;
import com.education.educationsystems.repository.StudentAnswerRepository;
@Service
public class StudentAnswerService {

	@Autowired
	private StudentAnswerRepository studentAnswerRepository;
	
	
	public StudentAnswer createRecord(StudentAnswer studentAnswer) {
		
		return studentAnswerRepository.save(studentAnswer);
	}

}
