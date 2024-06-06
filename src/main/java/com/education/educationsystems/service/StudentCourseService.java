package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.StudentCourse;
import com.education.educationsystems.repository.StudentCourseRepository;

@Service
public class StudentCourseService {

	@Autowired
	private StudentCourseRepository studentCourseRepository;
	public StudentCourse createRecord(StudentCourse studentCourse) {
		return studentCourseRepository.save(studentCourse);
	}
	public List<StudentCourse> assignCourseToStudent(Long id) {
		
		return studentCourseRepository.findAllByStudentId(id);
	}
	//delete a value
	public Map<String,Object> deleteByIdRecord(Long id){
		Map<String,Object> responce=new HashMap<>();
		boolean ifIdExit=studentCourseRepository.existsById(id);
		if(ifIdExit) {
			studentCourseRepository.deleteById(id);
			responce.put("Id Successfully Delete ", id);
			return responce;
		}
		responce.put("Id Not Found ", id);
		return responce;			
	}
	
}
