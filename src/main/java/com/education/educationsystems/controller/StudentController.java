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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.DTO.StudentDetailDTO;
import com.education.educationsystems.entity.MarkManagement;
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
	
	@GetMapping("/specific-mark")
	public MarkManagement retriveMark(@RequestParam Long studentId,@RequestParam Long courseId) {
		return studentService.retriveMark(studentId,courseId);
	}
	
	@GetMapping("/all-record/{id}")
	public List<StudentAnswer> retriveAllMark(@PathVariable Long id){
//		System.out.println(id);
		return studentService.retriveAllMark(id);
	}
		
	@GetMapping("/retrive-student-detail")
	public StudentDetailDTO retriveStudentDetail(@RequestParam Long studentId,@RequestParam Long courseId) {
		return studentService.retriveStudentDetail(studentId, courseId);
	}
	@GetMapping("/search")
	public List<Student> searchStudent(@RequestParam(required=false) String name,@RequestParam(required=false) Long schoolId,@RequestParam(required=false) String address){
		return studentService.searchStudent(name,schoolId,address);
	}
	
	@GetMapping("/search/name")
	public List<Student> searchStudentName(@RequestParam String name){
		return studentService.searchStudentName(name);
	}
	@GetMapping("/search/address")
	public List<Student> searchAddress(@RequestParam String address){
		return studentService.searchAddress(address);
	}
	
}
