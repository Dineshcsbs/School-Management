package com.education.educationsystems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{



	List<Tutor> findAllBySchoolId(Long id);

	
	@Query(value="SELECT * FROM STUDENT "
			+"WHERE (:name IS NULL OR name =:name)"
			+"AND (:address IS NULL OR address = :address)"
			+"AND (:schoolId IS NULL OR school_id = :schoolId)"
			,nativeQuery=true)
	
	List<Tutor> searchTutor(@Param("name") String name,@Param("schoolId") Long schoolId,@Param("address") String address);
	
//	@Query(value = "SELECT tc.tutor_id.school_id, ts.salary FROM tutor_course tc JOIN tutor_salary ts ON tc.tutor_id = ts.tutor_id WHERE ts.salary > :salaryThreshold", nativeQuery = true)
//	@Query(value = "SELECT * FROM salary s WHERE s.salary > :salaryThreshold", nativeQuery = true)
	@Query(value = "SELECT s.tutor_id.school_id FROM tutor_salary s WHERE s.salary > :salaryThreshold", nativeQuery = true)
	List<Object[]> findTutorsWithSalaryAboveNative(@Param("salaryThreshold") Double salaryThreshold);
	
	
//	@Query("SELECT c, t.name AS tutorName, s.name AS schoolName FROM Course c " +
//	        "JOIN Tutor t ON c.tutorId = t.id " +
//	        "JOIN School s ON c.schoolId = s.id")
//	List<Object[]> findTutorsWithSalaryAboveNati();
	
	
	

}
