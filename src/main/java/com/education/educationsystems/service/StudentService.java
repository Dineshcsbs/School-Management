package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.DTO.StudentDetailDTO;
import com.education.educationsystems.entity.MarkManagement;
import com.education.educationsystems.entity.Student;
import com.education.educationsystems.entity.StudentAnswer;
import com.education.educationsystems.repository.MarkManagementRepository;
import com.education.educationsystems.repository.StudentAnswerRepository;
import com.education.educationsystems.repository.StudentRepository;

@Service
public class StudentService {


	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentAnswerRepository studentAnswerRepository;
	
	@Autowired
	private MarkManagementRepository markManagementRepository ;
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
	public MarkManagement retriveMark(Long studentId, Long courseId) {
		List<MarkManagement> studentMark=markManagementRepository.findByStudentIdAndCourseId(studentId,courseId);
		return studentMark.get(0);
	}
	public List<StudentAnswer> retriveAllMark(Long studentId) {
		return studentAnswerRepository.findAllByStudentId(studentId);
	}
	
	public List<StudentDetailDTO> retriveStudentDetail(Long studentId,Long courseId) {
		List<MarkManagement> studentMark=markManagementRepository.findByStudentIdAndCourseId(studentId, courseId);
		List<StudentDetailDTO> studentDetails=new LinkedList<>();
		for(MarkManagement mark:studentMark) {
			studentDetails.add(updateDetails(mark));
		}
		return studentDetails;	
	}
	
	
	private StudentDetailDTO updateDetails(MarkManagement markManagement) {
		
		return StudentDetailDTO.builder()
				.schoolName(markManagement.getStudent().getSchool().getName())
				.studentId(markManagement.getStudent().getId())
				.name(markManagement.getStudent().getName())
				.course(markManagement.getCourse().getName())
				.mark(markManagement.getMark())
				.build();			
	}
	public List<Student> searchStudentName(String name) {
//		Search s=name;
		return studentRepository.findByName(name);
	}
	public List<Student> searchAddress(String address) {
		return studentRepository.findByAddress(address);
		
	}
	public List<Student> searchStudent(String name, Long schoolId, String address) {
		return studentRepository.searchStudent(name,schoolId,address);
//		return studentRepository.findByNameAndAddressAndSchoolId(name, address, schoolId);
	}
	public List<Student> getAllRecord() {
		return studentRepository.findAll();
	}
}
