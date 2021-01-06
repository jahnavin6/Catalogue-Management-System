package com.softwareengineering.cms.repository;

import com.softwareengineering.cms.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByEmailId(String emailId);
    Department findByName(String name);
}
