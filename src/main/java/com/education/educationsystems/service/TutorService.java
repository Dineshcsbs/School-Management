package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.DTO.SalaryDTO;
import com.education.educationsystems.DTO.TutorDTO;
import com.education.educationsystems.entity.Tutor;
import com.education.educationsystems.entity.TutorCourse;
import com.education.educationsystems.entity.TutorSalary;
import com.education.educationsystems.repository.TutorCourseRepository;
import com.education.educationsystems.repository.TutorRepository;
import com.education.educationsystems.repository.TutorSalaryRepository;

@Service
public class TutorService {

	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private TutorSalaryRepository tutorSalaryRepository;
	@Autowired
	private TutorCourseRepository tutorCourseRepository;

	public Tutor createRecord(Tutor tutor) {
		return tutorRepository.save(tutor);
	}
	
	public Map<String, Object> deleteByIdRecord(Long id) {
		Map<String, Object> responce = new HashMap<>();
		boolean ifIdExit = tutorRepository.existsById(id);
		if (ifIdExit) {
			tutorRepository.deleteById(id);
			responce.put("Id Successfully Delete ", id);
			return responce;
		}
		responce.put("Id Not Found ", id);
		return responce;

	}

	public List<TutorSalary> getTutorSalariesBySchoolId(Long id, Double salary) {
		List<Tutor> tutorList = tutorRepository.findAllBySchoolId(id);
		return getTutorSalarie(tutorList, salary);
	}

	public List<TutorSalary> getTutorSalarie(List<Tutor> tutorList, Double salary) {
		List<Long> tutorIds = tutorList.stream().map(Tutor::getId).collect(Collectors.toList());
		List<TutorSalary> salaries = tutorSalaryRepository.findAllByTutorIdInAndSalaryGreaterThanEqual(tutorIds,salary);
		return salaries;

	}


	public List<TutorDTO> searchTutor(String name, Long schoolId, String address) {
		
		return counvertTutorDTO(tutorCourseRepository.findTutorCoursesByFilter(schoolId,name,address));
		
	}

	private List<TutorDTO> counvertTutorDTO(List<TutorCourse> listOfcourse) {
		List<TutorDTO> listOfTutor = new LinkedList<>();
		for (TutorCourse course : listOfcourse) {
			listOfTutor.add(TutorDTO.builder().name(course.getTutor().getName())
					.address(course.getTutor().getAddress())
					.subjectName(course.getCourse().getName())
					.schoolName(course.getTutor().getSchool().getName())
					.build());
		}
		return listOfTutor;

	}
	public List<SalaryDTO> salary() {
	    List<Object[]> listSalary = tutorRepository.findTutorsWithSalaryAboveNative(20000D);
	    List<SalaryDTO> salaryDetails = new LinkedList<>();

	    for (Object[] salary : listSalary) {
	    	System.out.println(salary[0]);
	    }
//	    for (Object[] salary : listSalary) {
//	        Long courseId = (Long) salary[0];
//	        TutorCourse tutorCourse = new TutorCourse();
//	        tutorCourse.setId(courseId);
//
//	        salaryDetails.add(
//	            SalaryDTO.builder()
//	                .name(tutorCourse.getTutor().getName())
//	                .schoolName(tutorCourse.getTutor().getSchool().getName())
//	                .course(tutorCourse.getCourse().getName())
//	                .salary((Double) salary[1])
//	                .address(tutorCourse.getTutor().getAddress())
//	                .build()
//	        );
//	    }

	    return salaryDetails;
	}

}
