package com.education.educationsystems.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDTO {

	private Long questionId;
	private String question;
	private String option1;
	private String option2;
//	private Long sdid;
	
//	@Override
//	public String toString() {
//		return "QuestionDTO : {"
//				+ "questionId : "+questionId
//				+ "question : " + question
//				+ "option1 : "+ option1
//				+"option1 : "+option2
//				+ "}";
//	}
	/*
	questionDTO.toString();
	tutorList.forEach(t -> {
		t.setAddress(questionDTO.toString());
	});
	this.tutorRepository.save()
	*/
	
}
