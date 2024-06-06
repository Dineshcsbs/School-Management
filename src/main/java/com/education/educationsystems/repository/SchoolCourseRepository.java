package com.education.educationsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.SchoolCourse;

@Repository
public interface SchoolCourseRepository extends JpaRepository<SchoolCourse, Long>{

	long countBySchoolId(Long id);

}
