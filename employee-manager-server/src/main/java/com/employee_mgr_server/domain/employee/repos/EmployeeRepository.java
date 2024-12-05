package com.employee_mgr_server.domain.employee.repos;

import com.employee_mgr_server.domain.employee.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}