package com.softwareengineering.cms.service;

import com.softwareengineering.cms.model.Student;
import com.softwareengineering.cms.model.Ticket;

import java.util.Set;

public interface UserService {
    Boolean validateUser(String emailId, String password);
    void createUser(Student student);
    void createTicket(String utaId, String departmentName, Ticket ticket);
    Set<Ticket> viewTickets(String utaId);
}
