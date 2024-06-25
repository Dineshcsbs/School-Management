package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.education.educationsystems.entity.School;
import com.education.educationsystems.repository.SchoolCourseRepository;
import com.education.educationsystems.repository.SchoolRepository;
import com.education.educationsystems.repository.StudentRepository;
import com.education.educationsystems.repository.TutorRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private SchoolCourseRepository schoolCourseRepository;
	
	public School createRecord(School school) {
		return schoolRepository.save(school);
	}

	public List<Object> getStudentAndTeacherDetailsBySchoolName(@PathVariable Long id) {
		List<Object> student=new LinkedList<>();
		
	    student.add( studentRepository.findAllBySchoolId(id));
	    student.add( tutorRepository.findAllBySchoolId(id));    
	    return student;
	}
	
	public long getSchoolsWithTotalCourseCounts(Long id) {
		return schoolCourseRepository.countBySchoolId(id);
	}


	public Map<String,Object> deleteByIdRecord(Long id){
		Map<String,Object> responce=new HashMap<>();
		boolean ifIdExit=schoolRepository.existsById(id);
		if(ifIdExit) {
			schoolRepository.deleteById(id);
			responce.put("Id Successfully Delete ", id);
			return responce;
		}
		responce.put("Id Not Found ", id);
		return responce;
		
	}
	
	public Map<String, Object> updateByRecord(Long id, School schoolResponce) {
		Map<String,Object> responce=new HashMap<>();
		Optional<School> schoolId=schoolRepository.findById(id);
		if(schoolId.isEmpty()) {
			responce.put("Id Not Found ", id);
			return responce;
		}
		School school=schoolId.get();
		if(schoolResponce.getAddress()!=null) {
			school.setAddress(schoolResponce.getAddress());
		}
		if(schoolResponce.getName()!=null) {
			school.setName(schoolResponce.getName());
		}	
		createRecord(school);
		responce.put("Successfully update ", id);
		return responce;
	}
	
	public List<School> getData() {
		return this.schoolRepository.findAll();
	}



	
}
