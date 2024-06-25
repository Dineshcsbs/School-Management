package com.education.educationsystems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.educationsystems.entity.School;
import com.education.educationsystems.service.SchoolService;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	
	@PostMapping("/")
	public School createRecord(@RequestBody School school) {
		return schoolService.createRecord(school);
	}
	
	@GetMapping("/")
	public List<School> getData(){
		return this.schoolService.getData();
	}
	
	@GetMapping("/{id}")
	public List<Object> getStudentAndTeacherDetailsBySchoolName(@PathVariable Long id){
		return schoolService.getStudentAndTeacherDetailsBySchoolName(id);
	}
	
	@GetMapping("/course-count/{id}")
	public Map<String,Long> getSchoolsWithTotalCourseCounts(@PathVariable Long id){
		final Map<String,Long> totalCourseCountInSchool=new HashMap<>();
		totalCourseCountInSchool.put("Total Course Available In a School ",(schoolService.getSchoolsWithTotalCourseCounts(id)));
		return totalCourseCountInSchool;
	}
	
	@PutMapping("/update/{id}")
	public Map<String,Object> updateByRecord(@PathVariable Long id,@RequestBody School school){
		return schoolService.updateByRecord(id,school);
	}	

	
	@DeleteMapping("/delete/{id}")
	public Map<String,Object> deleteByIdRecord(@PathVariable Long id){
		return schoolService.deleteByIdRecord(id);
	}
	

}
