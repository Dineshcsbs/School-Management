package com.education.educationsystems.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalaryDTO {

	private String name;
	private String schoolName;
	private String address;
	private String course;
	private Double salary;
}
