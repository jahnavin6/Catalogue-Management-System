package com.softwareengineering.cms.repository;

import com.softwareengineering.cms.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Set<Ticket> findByDepartmentId(Long deptId);
}
