package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.TutorSalary;
import com.education.educationsystems.repository.TutorSalaryRepository;

@Service
public class TutorSalaryService {

	@Autowired
	private TutorSalaryRepository tutorSalaryRepository;
	public TutorSalary createRecord(TutorSalary tutorSalary) {
		return tutorSalaryRepository.save(tutorSalary);
	}
	//delete a value
	public Map<String,Object> deleteByIdRecord(Long id){
		Map<String,Object> responce=new HashMap<>();
		boolean ifIdExit=tutorSalaryRepository.existsById(id);
		if(ifIdExit) {
			tutorSalaryRepository.deleteById(id);
			responce.put("Id Successfully Delete ", id);
			return responce;
		}
		responce.put("Id Not Found ", id);
		return responce;			
	}

}
