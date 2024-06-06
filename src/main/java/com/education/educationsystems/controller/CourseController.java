package com.education.educationsystems.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@DeleteMapping("/delete/{id}")
	public Map<String,Object> deleteByIdRecord(@PathVariable Long id){
		return courseService.deleteByIdRecord(id);
	}
	
//	@GetMapping("/{id1}/{id2}")
//	public void cc(@PathVariable("id1") int a,@PathVariable("id2")int b) {
//		System.out.print(a+"     "+b);
//	}
}
