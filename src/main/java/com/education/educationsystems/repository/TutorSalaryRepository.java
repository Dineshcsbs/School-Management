package com.education.educationsystems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.TutorSalary;
@Repository
public interface TutorSalaryRepository extends JpaRepository<TutorSalary, Long>{


//	List<TutorSalary> findAllByTutorIdInAndSalaryGreaterThanE(List<Long> tutorIds, Double salary);

//	List<TutorSalary> findAllByTutorIdIn(List<Long> tutorIds);

	List<TutorSalary> findAllByTutorIdInAndSalaryGreaterThanEqual(List<Long> tutorIds, Double salary);

	

}
