package com.education.educationsystems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

//	List<Question> findAllByCourseId(Long courseId);

//	List<String> findAllByAnsIn(List<Long> questionIds);

//	Collection<StudentAnswer> findAllByQuestionIdIn(List<Long> questionIds);
//
//	Collection<StudentAnswer> findAllByAnsIdIn(List<Long> questionIds);

//	List<Question> findAllByIdIn(List<Long> questionIds);

//	List<String> findAllByIdIn(List<Long> questionIds);
//	@Query("select u.question,u.option1,u.option2 from Question u where u.courseId = ?1")
//	  Question findByQuestion(Long courseId);

	List<Question> findAllByCourseId(Long id);

	
	List<Question> findALLByIdIn(List<Long> questionId);

}
