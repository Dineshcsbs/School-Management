package com.education.educationsystems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

//	Object findAllByStudentId(Long id);

//	List<Object> findAllBySchoolName(String schoolName);

	List<Object> findAllBySchoolId(Long schoolId);

	List<Student> findByName(String name);

	List<Student> findByAddress(String address);

	List<Student> findByNameAndAddressAndSchoolId(String name, String address, Long schoolId);
	
	
	@Query(value="SELECT * FROM STUDENT "
			+"WHERE (:name IS NULL OR name =:name)"
			+"AND (:address IS NULL OR address = :address)"
			+"AND (:schoolId IS NULL OR school_id = :schoolId)"
			,nativeQuery=true)
	
	List<Student> searchStudent(@Param("name") String name,@Param("schoolId") Long schoolId,@Param("address") String address);

//	default Iterable<Student> search(String field, String value) {
//        PathBuilder<Student> entityPath = new PathBuilder<>(Student.class, "student");
//        StringPath path = entityPath.getString(field);
//        return findAll(path.containsIgnoreCase(value));
//    }
}
