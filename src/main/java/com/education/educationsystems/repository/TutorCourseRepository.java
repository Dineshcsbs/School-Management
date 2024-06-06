package com.education.educationsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.TutorCourse;
@Repository
public interface TutorCourseRepository extends JpaRepository<TutorCourse, Long>{

	

}
