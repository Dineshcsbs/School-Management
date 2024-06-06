package com.education.educationsystems.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.entity.Tutor;
import com.education.educationsystems.entity.TutorSalary;
import com.education.educationsystems.service.TutorService;

@RestController
@RequestMapping("/ai/tutor")
public class TutorController {

	@Autowired
	private TutorService tutorService;
	
	@PostMapping("/")
	public Tutor createRecord(@PathVariable Tutor tutor) {
		return tutorService.createRecord(tutor);
	}
	
	@GetMapping("/{id}")
	public List<TutorSalary> getTutorSalariesBySchoolId(@PathVariable Long id){
		return tutorService.getTutorSalariesBySchoolId(id,20000D);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String,Object> deleteByIdRecord(@PathVariable Long id){
		return tutorService.deleteByIdRecord(id);
	}
}
