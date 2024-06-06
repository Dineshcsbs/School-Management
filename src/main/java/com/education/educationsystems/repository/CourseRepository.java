package com.education.educationsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	
}
