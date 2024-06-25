package com.education.educationsystems.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.entity.TutorSalary;
import com.education.educationsystems.service.TutorSalaryService;

@RestController
@RequestMapping("/api/tutor-salary")
public class TutorSalaryController {

	@Autowired
	private TutorSalaryService tutorSalaryService;
	
	@PostMapping("/")
	public TutorSalary createRecord(@RequestBody TutorSalary tutorSalary) {
		return tutorSalaryService.createRecord(tutorSalary);
	}
	
	@GetMapping("/")
	public List<TutorSalary> retriveTutorSalary(){
		return tutorSalaryService.retriveTutorSalary();
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,Object> deleteByIdRecord(@PathVariable Long id){
		return tutorSalaryService.deleteByIdRecord(id);
	}
}
