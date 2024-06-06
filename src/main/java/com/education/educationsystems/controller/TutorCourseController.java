package com.education.educationsystems.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.entity.TutorCourse;
import com.education.educationsystems.service.TutorCourseService;

@RestController
@RequestMapping("/api/tutor-course")
public class TutorCourseController {

	@Autowired
	private TutorCourseService tutorCourseService;
	
	@PostMapping("/")
	public TutorCourse createrecord(@RequestBody TutorCourse tutorCourse) {
		return tutorCourseService.createRecord(tutorCourse);
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,Object> deleteByIdRecord(@PathVariable Long id){
		return tutorCourseService.deleteByIdRecord(id);
	}
}
