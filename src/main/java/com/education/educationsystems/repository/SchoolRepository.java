package com.education.educationsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.educationsystems.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

}
