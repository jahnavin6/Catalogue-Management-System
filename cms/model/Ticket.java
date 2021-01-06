package com.softwareengineering.cms.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String description;

    @Column
    private Integer status;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Department department;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Student student;
}
