package com.education.educationsystems.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.entity.SchoolCourse;
import com.education.educationsystems.service.SchoolCourseService;

@RestController
@RequestMapping("/api/school-course")
public class SchoolCourseController {

	@Autowired
	private SchoolCourseService schoolCourseService;
	
	@PostMapping("/")
	public SchoolCourse createRecord(@RequestBody SchoolCourse schoolCourse) {
		return schoolCourseService.createRecord(schoolCourse);
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,Object> deleteByIdRecord(@PathVariable Long id){
		return schoolCourseService.deleteByIdRecord(id);
	}
}
