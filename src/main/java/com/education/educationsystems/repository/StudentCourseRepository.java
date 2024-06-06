package com.education.educationsystems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long>{

//	List<StudentCourse> findAllById(Long id);

	List<StudentCourse> findAllByStudentId(Long id);

}
