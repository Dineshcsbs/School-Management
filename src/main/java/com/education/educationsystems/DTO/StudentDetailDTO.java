package com.education.educationsystems.DTO;

import lombok.Builder;
import lombok.Data;



@Data 
@Builder
public class StudentDetailDTO {

	private String schoolName;
	private Long studentId;
	private String name;
	private String course;
	private int mark;
	
	
}
