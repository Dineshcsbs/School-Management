package com.education.educationsystems.DTO;

import lombok.Getter;
import lombok.Setter;


//@Accessors(fluent = true, chain = true)
@Getter 
@Setter
public class StudentDetailDTO {


	private Long studentId;

	private String name;

	private String course;
	
}
