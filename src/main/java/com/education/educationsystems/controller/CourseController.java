package com.education.educationsystems.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.entity.Course;
import com.education.educationsystems.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/")
	public Course createRecord(@RequestBody Course course) {
		return courseService.createRecord(course);
	}
	@GetMapping("/{courseId}")
	public Course getCourseName(@PathVariable Long courseId) {
		return courseService.getCourseName(courseId);
	}
	
	@DeleteMapping("/delete/{courseId}")
	public Map<String,Object> deleteById(@PathVariable Long courseId){
		return courseService.deleteByIdRecord(courseId);
	}
	
}
