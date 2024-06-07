package com.education.educationsystems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="course")
@Data
public class Course {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	public Course() {
        
    }
	
	public Course(Long id) {
        this.id = id;
    }
//	public static Course getId(Long courseId) {
//		// TODO Auto-generated method stub
//		return 
//	}
}
