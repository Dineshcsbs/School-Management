package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.Student;
import com.education.educationsystems.entity.StudentAnswer;
import com.education.educationsystems.repository.StudentAnswerRepository;
import com.education.educationsystems.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentAnswerRepository studentAnswerRepository;
	
	public Student createRecord(Student student) {
		return studentRepository.save(student);
	}
	//delete a value
	public Map<String,Object> deleteByIdRecord(Long id){
		Map<String,Object> responce=new HashMap<>();
		boolean ifIdExit=studentRepository.existsById(id);
		if(ifIdExit) {
			studentRepository.deleteById(id);
			responce.put("Id Successfully Delete ", id);
			return responce;
		}
		responce.put("Id Not Found ", id);
		return responce;			
	}
	public Optional<StudentAnswer> retriveMark(Long studentId, Long courseId) {
		
		return studentAnswerRepository.findByStudentIdAndCourseId(studentId,courseId);
	}
	public List<StudentAnswer> retriveAllMark(Long studentId) {
		return studentAnswerRepository.findAllByStudentId(studentId);
	}

}
