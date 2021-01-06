package com.softwareengineering.cms.repository;

import com.softwareengineering.cms.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmailId(String emailId);
    Admin findByUtaId(String utaId);
}
