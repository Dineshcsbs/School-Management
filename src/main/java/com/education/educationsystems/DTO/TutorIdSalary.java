package com.education.educationsystems.DTO;

import com.education.educationsystems.entity.TutorCourse;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorIdSalary {

	@OneToMany
	private TutorCourse tutorCourse;
}
