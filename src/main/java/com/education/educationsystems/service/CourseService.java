package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.Course;
import com.education.educationsystems.repository.CourseRepository;
@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository; 
	public Course createRecord(Course course) {
		
		return courseRepository.save(course);
	}

	//delete a value
		public Map<String,Object> deleteByIdRecord(Long id){
			Map<String,Object> responce=new HashMap<>();
			boolean ifIdExit=courseRepository.existsById(id);
			if(ifIdExit) {
				courseRepository.deleteById(id);
				responce.put("Id Successfully Delete ", id);
				return responce;
			}
			responce.put("Id Not Found ", id);
			return responce;
			
		}
}
