package com.education.educationsystems.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.education.educationsystems.DTO.QuestionDTO;
import com.education.educationsystems.entity.Question;
import com.education.educationsystems.repository.QuestionRepository;
@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}
	public List<QuestionDTO> displayQuestion(Long courseId) {
		
		List<QuestionDTO> listOfQuestion=new LinkedList<>();
		
		List<Question> question=questionRepository.findAllByCourseId(courseId);//list of question available for particular id
		
		Iterator<Question> questionIterator=question.iterator();

		while(questionIterator.hasNext()) {
			listOfQuestion.add(convertToDTO(questionIterator.next()));	
		}
		return listOfQuestion;
	}
	
	public Page<QuestionDTO> pageConcept(int offSet,int pageSize){
		
		Page<Question> responce=questionRepository.findAll(PageRequest.of(offSet,pageSize));
		
		Page<QuestionDTO> responce1=responce.map(this::convertToDTO);
		return responce1;
		
	}
	public QuestionDTO convertToDTO(Question question) {
		
		return QuestionDTO.builder()
		.questionId(question.getId())
		.question(question.getQuestion())
		.option1(question.getOption1())
		.option2(question.getOption2())
		.build();
		
		
			
		/*
			QuestionDTO questionDTO=new QuestionDTO();
			questionDTO.setQuestionId(singleQuestion.getId());
			questionDTO.setQuestion(singleQuestion.getQuestion());
			questionDTO.setOption1(singleQuestion.getOption1());
			questionDTO.setOption2(singleQuestion.getOption2());
			return questionDTO;	
			*/		 
	}
	
	
	

}
