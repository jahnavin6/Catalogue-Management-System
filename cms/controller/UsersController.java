package com.softwareengineering.cms.controller;

import com.softwareengineering.cms.exception.*;
import com.softwareengineering.cms.model.Student;
import com.softwareengineering.cms.model.Ticket;
import com.softwareengineering.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    @ExceptionHandler({StudentAlreadyExistsException.class, AdminAlreadyExistsException.class})
    public ResponseEntity<String> createUser(@RequestBody Student student){
        userService.createUser(student);
        return new ResponseEntity<>("created new student", HttpStatus.OK);
    }

    @PostMapping("/validateUser")
    @ExceptionHandler({UserNotFoundException.class, InvalidCredentialsException.class})
    public ResponseEntity<String> validateUser(@RequestBody String emailId, @RequestBody String password){
        userService.validateUser(emailId, password);
        return new ResponseEntity<>("User credentials are valid", HttpStatus.OK);
    }

    @PostMapping("{utaId}/department/{departmentName}/createTicket")
    @ExceptionHandler({DepartmentDoesntExistsException.class})
    public ResponseEntity<String> createTicket(@PathVariable String utaId, @PathVariable String departmentName,  @RequestBody Ticket ticket){
        userService.createTicket(utaId, departmentName, ticket);
        return new ResponseEntity<>("Ticket is created", HttpStatus.OK);
    }

    @GetMapping("/{utaId}/viewTickets")
    public ResponseEntity<Set<Ticket>> viewTickets(@PathVariable String utaId){
        return new ResponseEntity<>(userService.viewTickets(utaId), HttpStatus.OK);
    }
}
