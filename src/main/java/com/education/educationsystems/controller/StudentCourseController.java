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

import com.education.educationsystems.entity.StudentCourse;
import com.education.educationsystems.service.StudentCourseService;

@RestController
@RequestMapping("/api/student-course")
public class StudentCourseController {

	@Autowired
	private StudentCourseService studentCourseService;
	@PostMapping("/")
	public StudentCourse createRecord(@RequestBody StudentCourse studentCourse) {
		return studentCourseService.createRecord(studentCourse);
	}
	
	@GetMapping("/{id}")
	public List<StudentCourse> assignCourseToStudent(@PathVariable Long id){
		return studentCourseService.assignCourseToStudent(id);
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,Object> deleteByIdRecord(@PathVariable Long id){
		return studentCourseService.deleteByIdRecord(id);
	}
}
