package com.education.educationsystems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.Tutor;
import com.education.educationsystems.entity.TutorSalary;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{

	//List<List<Object>> findAllByTutorId(Long id);

//	List<Object> findAllBySchoolName(String schoolName);
//
//	List<Object> findAllById(Long id);

	List<Tutor> findAllBySchoolId(Long id);

}
