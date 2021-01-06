package com.softwareengineering.cms.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    @NotBlank(message = "emailId is mandatory")
    private String emailId;

    @Column
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    @EqualsAndHashCode.Exclude
    private Set<Ticket> tickets;
}
