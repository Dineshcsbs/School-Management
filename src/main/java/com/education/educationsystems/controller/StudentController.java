package com.education.educationsystems.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.entity.Student;
import com.education.educationsystems.entity.StudentAnswer;
import com.education.educationsystems.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/")
	public Student createRecord(@RequestBody Student student) {
		return studentService.createRecord(student);
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,Object> deleteByIdRecord(@PathVariable Long id){
		return studentService.deleteByIdRecord(id);
	}
	
	@GetMapping("/specific-mark/{id1}/{id2}")
	public Optional<StudentAnswer> retriveMark(@PathVariable("id1") Long studentId,@PathVariable("id2") Long courseId) {
		return studentService.retriveMark(studentId,courseId);
	}
	
	@GetMapping("/all-record/{id}")
	public List<StudentAnswer> retriveAllMark(@PathVariable Long id){
//		System.out.println(id);
		return studentService.retriveAllMark(id);
	}
	
	
}
