package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.TutorCourse;
import com.education.educationsystems.repository.TutorCourseRepository;
@Service
public class TutorCourseService {

	@Autowired
	private TutorCourseRepository tutorCourseRepository;
	public TutorCourse createRecord(TutorCourse tutorCourse) {
		return tutorCourseRepository.save(tutorCourse);
	}

	//delete a value
	public Map<String,Object> deleteByIdRecord(Long id){
		Map<String,Object> responce=new HashMap<>();
		boolean ifIdExit=tutorCourseRepository.existsById(id);
		if(ifIdExit) {
			tutorCourseRepository.deleteById(id);
			responce.put("Id Successfully Delete ", id);
			return responce;
		}
		responce.put("Id Not Found ", id);
		return responce;			
	}
}
