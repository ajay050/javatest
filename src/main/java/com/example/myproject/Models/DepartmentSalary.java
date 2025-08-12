package com.example.myproject.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="department_salary")
public class DepartmentSalary {
    @Id
    private Long deptId;

    @Column(name="salary")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity user;
}
