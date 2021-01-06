package com.softwareengineering.cms.repository;

import com.softwareengineering.cms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmailId(String emailId);
    Student findByUtaId(String utaId);
}
