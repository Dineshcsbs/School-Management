package com.education.educationsystems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

//	Object findAllByStudentId(Long id);

//	List<Object> findAllBySchoolName(String schoolName);

	List<Object> findAllBySchoolId(Long schoolId);

}
