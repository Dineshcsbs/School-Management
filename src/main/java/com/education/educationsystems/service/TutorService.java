package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.Tutor;
import com.education.educationsystems.entity.TutorSalary;
import com.education.educationsystems.repository.TutorRepository;
import com.education.educationsystems.repository.TutorSalaryRepository;

@Service
public class TutorService {

	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private TutorSalaryRepository tutorSalaryRepository;
	
	public Tutor createRecord(Tutor tutor) {
		return tutorRepository.save(tutor);
	}
	//delete a value
	public Map<String,Object> deleteByIdRecord(Long id){
		Map<String,Object> responce=new HashMap<>();
		boolean ifIdExit=tutorRepository.existsById(id);
		if(ifIdExit) {
			tutorRepository.deleteById(id);
			responce.put("Id Successfully Delete ", id);
			return responce;
		}
		responce.put("Id Not Found ", id);
		return responce;
		
	}
	
	public List<TutorSalary> getTutorSalariesBySchoolId(Long id,Double salary) {
		List<Tutor> tutorList= tutorRepository.findAllBySchoolId(id);
		
//		QuestionDTO questionDTO = new QuestionDTO();
//		questionDTO.setOption1("ok");
//		questionDTO.setOption2("ll");
//		questionDTO.setQuestion("ss");
		
		
		return getTutorSalarie(tutorList,salary);
	}
	public List<TutorSalary> getTutorSalarie(List<Tutor> tutorList,Double salary){
		List<Long> tutorIds =  tutorList.stream().map(Tutor::getId).collect(Collectors.toList());
		List<TutorSalary> salaries = tutorSalaryRepository.findAllByTutorIdInAndSalaryGreaterThanEqual(tutorIds, salary);
		return salaries;
		
	}
}
