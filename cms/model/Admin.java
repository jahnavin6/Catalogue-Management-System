package com.softwareengineering.cms.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "admins")
public class Admin extends User {
    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
