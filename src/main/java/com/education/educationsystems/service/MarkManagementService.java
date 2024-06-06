package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.MarkManagement;
import com.education.educationsystems.entity.Question;
import com.education.educationsystems.entity.StudentAnswer;
import com.education.educationsystems.repository.CourseRepository;
import com.education.educationsystems.repository.MarkManagementRepository;
import com.education.educationsystems.repository.QuestionRepository;
import com.education.educationsystems.repository.StudentAnswerRepository;
import com.education.educationsystems.repository.StudentRepository;

@Service
public class MarkManagementService {


	@Autowired
	private StudentAnswerRepository studentAnswerRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private MarkManagementRepository markManagementRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	
	public MarkManagement retriveSingleRecord(Long studentId,Long courseId) {
		return markManagementRepository.findByStudentIdAndCourseId(studentId,courseId);
	}
	
	public Map<String,String> studentMarkUpdated(){
		Map<String,String> markResponce=new HashMap<>();
		Map<Long,Map<Long,Long>> markCalculate=new HashMap<>();
		List<StudentAnswer> studentAns=studentAnswerRepository.findByOrderByQuestionAsc();
		List<Long> listOfQuestionId=(studentAns.stream().map(StudentAnswer::getQuestion).collect(Collectors.toList()))
				.stream().map(Question::getId).collect(Collectors.toList());
		List<Question> question=questionRepository.findALLByIdIn(listOfQuestionId);
		
		int questionId=0;
		for(int i=0;i<studentAns.size();i++) {
			if((studentAns.get(i).getQuestion().getId()==question.get(questionId).getId())||(studentAns.get(i).getQuestion().getId()==question.get(++questionId).getId())) {
				if(studentAns.get(i).getStudentAns().equals(question.get(questionId).getAns())) {
					Long studentId=studentAns.get(i).getStudent().getId();
					Long courseId=studentAns.get(i).getCourse().getId();
					if(markCalculate.containsKey(courseId)) {
						Map<Long,Long> studentMarkList=markCalculate.get(courseId);	
						
						if(studentMarkList.containsKey(studentId)) {
							studentMarkList.put(studentId, studentMarkList.get(studentId)+1);
						}
						else {
							studentMarkList.put(studentId,1L);
						}
						markCalculate.put(courseId, studentMarkList);
					}
					else {
						Map<Long,Long> newMarkAdd=new HashMap<>();
						
						if(markCalculate.containsKey(studentId)) {
							newMarkAdd.put(studentId, newMarkAdd.get(studentId)+1);
						}
						else {
							newMarkAdd.put(studentId, 1L);
						}
						markCalculate.put(courseId, newMarkAdd);
						
					}
				}
			}
		}
		for(Long courseId:markCalculate.keySet()) {
			Map<Long,Long> studentMark=markCalculate.get(courseId);
			for(Long student:studentMark.keySet()) {
				

				MarkManagement markManagement=new MarkManagement();
				markManagement.setStudent(studentRepository.findById(student).orElseThrow());
				
				markManagement.setMark((studentMark.get(student)).intValue());
				
				markManagement.setCourse(courseRepository.findById(courseId).orElseThrow());
				markManagementRepository.save(markManagement);
			}
		}
				
		markResponce.put("Update", "Success");
		return markResponce;
	}
}
	
	/*
	public Map<String,String> studentMarkUpdated(){
		Map<String,String> markResponce=new HashMap<>();
		
		Map<Long,Long> markCalculate=new HashMap<>();
		List<StudentAnswer> studentAns=studentAnswerRepository.findByOrderByQuestionAsc();
		List<Long> listOfQuestionId=(studentAns.stream().map(StudentAnswer::getQuestion).collect(Collectors.toList()))
				.stream().map(Question::getId).collect(Collectors.toList());
		List<Question> question=questionRepository.findALLByIdIn(listOfQuestionId);
		int questionId=0;
		for(int i=0;i<studentAns.size();i++) {
			if((studentAns.get(i).getQuestion().getId()==question.get(questionId).getId())||(studentAns.get(i).getQuestion().getId()==question.get(++questionId).getId())) {
				if(studentAns.get(i).getStudentAns().equals(question.get(questionId).getAns())) {
					Long studentId=studentAns.get(i).getStudent().getId();
					if(markCalculate.containsKey(studentId)) {
						markCalculate.put(studentId, markCalculate.get(studentId)+1);
					}
					else {
						markCalculate.put(studentId, 1L);
					}
				}
			}
		}
		
		
		for(Long studentId:markCalculate.keySet()){
			MarkManagement markManagement=new MarkManagement();
			markManagement.setStudent(studentRepository.findById(studentId).orElseThrow());
			
			markManagement.setMark((markCalculate.get(studentId)).intValue());
			
			markManagement.setCourse(courseRepository.findById(401L).orElseThrow());
			markManagementRepository.save(markManagement);
		}

		 
		markResponce.put("success", "Updated");
		return markResponce;
	}
	
	
	
}

*/
	//==================================
/*
	public void studentMarkUpdated(Long studentId,Long courseId) {

		List<StudentAnswer> listOfStudentAnswer=studentAnswerRepository.findAllByStudentIdAndCourseId(studentId,courseId);

		List<Long> questionIds =  (listOfStudentAnswer.stream().map(StudentAnswer::getQuestion).collect(Collectors.toList()))
				                   .stream().map(Question::getId).collect(Collectors.toList());

		List<String> studentAns =  listOfStudentAnswer.stream().map(StudentAnswer::getStudentAns).collect(Collectors.toList());
	
		List<String> rightAns = questionRepository.findAllByIdIn(questionIds).stream().map(Question::getAns).collect(Collectors.toList());
	

		Iterator<String> iterator=studentAns.iterator();
		Iterator<String> iterator1=rightAns.iterator();
		Integer totalMark=0;
		
//		System.out.println(studentAns);
//		System.out.println(rightAns);
//		System.out.println(questionIds);
		while(iterator.hasNext()) {
			totalMark+=iterator.next().equals(iterator1.next())?1:0;
		}
//		System.out.println(totalMark);
		MarkManagement markManagement = new MarkManagement();
		markManagement.setId(1L);
		markManagement.setCourse(courseRepository.findById(courseId).orElseThrow());
        markManagement.setMark(totalMark);
        markManagement.setStudent(studentRepository.findById(studentId).orElseThrow());
        markManagementRepository.save(markManagement);
//        StudentDetailDTO detailDTO = new StudentDetailDTO();
//        detailDTO.g
        //https://projectlombok.org/p2
	}
	

	/*
	public void updateAllRecord() {
		List<Long> studentId=(studentAnswerRepository.findDistinctByStudentId()).stream()
				             .map(StudentAnswer::getId).collect(Collectors.toList());
		Iterator<Long> studentIdIterator=studentId.iterator();
		while(studentIdIterator.hasNext()) {
			List<Long> studentAnswerCourse=()
		}
		
	}
	
	
//	public void timepass() {
//		StudentDetailDTO studentDetailDTO=new StudentDetailDTO();
//		
//		
//	}

}
*/
