package com.example.myproject.repository;

import com.example.myproject.Models.DepartmentSalary;
import com.example.myproject.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentSalaryRepository extends JpaRepository<DepartmentSalary, Long> {
    Optional<DepartmentSalary> findByUser(UserEntity userId);
}
