package com.softwareengineering.cms.service;

import com.softwareengineering.cms.exception.*;
import com.softwareengineering.cms.model.*;
import com.softwareengineering.cms.repository.AdminRepository;
import com.softwareengineering.cms.repository.DepartmentRepository;
import com.softwareengineering.cms.repository.StudentRepository;
import com.softwareengineering.cms.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Boolean validateUser(String emailId, String password){
        User student = studentRepository.findByEmailId(emailId);
        User admin = adminRepository.findByEmailId(emailId);

        if(student == null && admin == null){
            throw new UserNotFoundException("User doesn't exist with emailId: " + emailId);
        }
        else{
            if((student != null && !student.getPassword().equalsIgnoreCase(password)) || (admin != null && !admin.getPassword().equalsIgnoreCase(password))){
                throw new InvalidCredentialsException(emailId);
            }
            return true;
        }
    }

    @Override
    public void createUser(Student student){
        Student retrievedUserByEmailId = studentRepository.findByEmailId(student.getEmailId());
        Student retrievedUserByUtaId = studentRepository.findByUtaId(student.getUtaId());
        Admin retrievedAdminByEmailId = adminRepository.findByEmailId(student.getEmailId());
        Admin retrievedAdminByUtaId = adminRepository.findByUtaId(student.getUtaId());
        if(retrievedUserByEmailId == null && retrievedUserByUtaId == null && retrievedAdminByEmailId == null && retrievedAdminByUtaId == null) {
            studentRepository.save(student);
        }
        else if(retrievedUserByEmailId != null || retrievedUserByUtaId != null){
            throw new StudentAlreadyExistsException(student.getEmailId(), student.getUtaId());
        }
        else {
            throw new AdminAlreadyExistsException(student.getEmailId(), student.getUtaId());
        }
    }

    @Override
    public void createTicket(String utaId, String departmentName, Ticket ticket){
        Department department = departmentRepository.findByName(departmentName);
        if(department == null){
            throw new DepartmentDoesntExistsException(departmentName);
        }
        ticket.setDepartment(department);
        Student retrievedUserByUtaId = studentRepository.findByUtaId(utaId);
        if(retrievedUserByUtaId == null){
            throw new UserNotFoundException("User doesn't exist with utaId: " + utaId);
        }
        ticket.setStudent(retrievedUserByUtaId);
        ticketRepository.save(ticket);
    }

    @Override
    public Set<Ticket> viewTickets(String utaId){
        Student retrievedUserByUtaId = studentRepository.findByUtaId(utaId);
        Admin retrievedAdminByUtaId = adminRepository.findByUtaId(utaId);
        if(retrievedUserByUtaId == null && retrievedAdminByUtaId == null){
            throw new UserNotFoundException("User doesn't exist with utaId: " + utaId);
        }
        else if(retrievedUserByUtaId != null){
            return retrievedUserByUtaId.getTickets();
        }
        else{
            return retrievedAdminByUtaId.getDepartment().getTickets();
        }
    }

}
