package com.education.educationsystems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.StudentAnswer;
@Repository
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Long>{

//	StudentAnswer findByIdwherestudentAndCourse(Long studentId, Long courseId);
//	 Optional<StudentAnswer> findByStudentAndCourse(Long studentId, Long courseId);
/*
	Optional<StudentAnswer> findByStudentIdAndCourseId(Long studentId, Long courseId);

	List<StudentAnswer> findAllByStudentId(Long studentId);

	List<StudentAnswer> findAllByStudentIdAndCourseId(Long studentId, Long courseId);
*/
	List<StudentAnswer> findByOrderByQuestionAsc();

	Optional<StudentAnswer> findByStudentIdAndCourseId(Long studentId, Long courseId);

	List<StudentAnswer> findAllByStudentId(Long studentId);

//	List<StudentAnswer> findByOrderByQuestionAsc();

//	List<StudentAnswer> findDistinctByStudentId();

}
