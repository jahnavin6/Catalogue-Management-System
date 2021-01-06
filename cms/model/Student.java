package com.softwareengineering.cms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class Student extends User {
    @Column
    private String apartmentNumber;

    @Column
    private String apartmentName;

    @Column
    private String major;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Set<Ticket> tickets;
}
