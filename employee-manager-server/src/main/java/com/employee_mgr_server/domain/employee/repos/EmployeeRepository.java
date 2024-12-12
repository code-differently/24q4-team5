package com.employee_mgr_server.domain.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee_mgr_server.domain.employee.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);

    List<Employee> findByUserId(String userId); // Get all employees for a specific Clerk UserID
}