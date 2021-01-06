package com.softwareengineering.cms.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column
    @NotBlank(message = "emailId is mandatory")
    private String emailId;

    @Column
    @NotBlank(message = "password is mandatory")
    private String password;

    @Column
    @NotBlank(message = "utaId is mandatory")
    private String utaId;
}
