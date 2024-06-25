package com.education.educationsystems.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.DTO.SalaryDTO;
import com.education.educationsystems.DTO.TutorDTO;
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
	public List<TutorSalary> getTutorSalariesBySchoolId(@PathVariable Long id) {
		return tutorService.getTutorSalariesBySchoolId(id, 20000D);
	}

	@GetMapping("/serch")
	public List<TutorDTO> searchTutor(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long schoolId, @RequestParam(required = false) String address) {
		return tutorService.searchTutor(name, schoolId, address);
	}
	
	@GetMapping("/salary")
	public List<SalaryDTO> salary(){
		return tutorService.salary();
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Object> deleteByIdRecord(@PathVariable Long id) {
		return tutorService.deleteByIdRecord(id);
	}
	
	

}
