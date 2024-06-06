package com.education.educationsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.MarkManagement;
@Repository
public interface MarkManagementRepository extends JpaRepository<MarkManagement, Long>{

	MarkManagement findByStudentIdAndCourseId(Long studentId, Long courseId);

//	@Query("delete School s where s.id = ")
//	int deleteDeactivatedUsersWithNoModifyingAnnotation();
	
//	@Query("SELECT p FROM MarkManagement p")
//	public List<Object[]> findById();
	
}
