package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.SchoolCourse;
import com.education.educationsystems.repository.SchoolCourseRepository;

@Service
public class SchoolCourseService {

	@Autowired
	private SchoolCourseRepository schoolCourseRepository;
	public SchoolCourse createRecord(SchoolCourse schoolCourse) {
		return schoolCourseRepository.save(schoolCourse);
	}

	
	public Map<String,Object> deleteByIdRecord(Long id){
		Map<String,Object> responce=new HashMap<>();
		boolean ifIdExit=schoolCourseRepository.existsById(id);
		if(ifIdExit) {
			schoolCourseRepository.deleteById(id);
			responce.put("Id Successfully Delete ", id);
			return responce;
		}
		responce.put("Id Not Found ", id);
		return responce;
				
	}
}
