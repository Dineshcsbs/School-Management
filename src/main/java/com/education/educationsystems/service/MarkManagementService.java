package com.education.educationsystems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.educationsystems.entity.Course;
import com.education.educationsystems.entity.MarkManagement;
import com.education.educationsystems.entity.Question;
import com.education.educationsystems.entity.Student;
import com.education.educationsystems.entity.StudentAnswer;
import com.education.educationsystems.repository.MarkManagementRepository;
import com.education.educationsystems.repository.QuestionRepository;
import com.education.educationsystems.repository.StudentAnswerRepository;

@Service
public class MarkManagementService {


	@Autowired
	private StudentAnswerRepository studentAnswerRepository;
	@Autowired
	private MarkManagementRepository markManagementRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
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
				markManagement.setStudent(new Student(student));
				
				markManagement.setMark((studentMark.get(student)).intValue());
				
				markManagement.setCourse( new Course(courseId));
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
		List<StudentAnswer> studentAns=studentAnswerRepository.findAll();
		List<MarkManagement> markDetails=new LinkedList<>();
		for(int i=0;i<studentAns.size();i++) {		
			Student student1=studentAns.get(i).getStudent();
			Course course1=studentAns.get(i).getCourse();
			String stuAns=studentAns.get(i).getStudentAns();
			String questionAns=studentAns.get(i).getQuestion().getAns();
			if(stuAns.equals(questionAns)) {
				Object type=this.findStudentList(student1,course1,markDetails);
				if(!(type.equals(false))) {
					MarkManagement m=(MarkManagement)type;
					m.setMark(m.getMark()+1);
				}
				else {
					MarkManagement markManagement=new MarkManagement();
					markManagement.setMark(1);
					markManagement.setStudent(student1);
					markManagement.setCourse(course1);
					markDetails.add(markManagement);
				}
			}	
		}	
		markResponce.put("Update", "Success");
		this.markManagementRepository.saveAll(markDetails);
		return markResponce;
	}
	private Object findStudentList(Student student1, Course course1, List<MarkManagement> markDetails) {
		for(MarkManagement markTable:markDetails) {
			if(Objects.equals(markTable.getStudent(), student1)&&Objects.equals(markTable.getCourse(), course1)) {
				return markTable;
			}
		}
		return false;
	}	
}
*/