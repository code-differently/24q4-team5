package com.employee_mgr_server.domain.employee.services;

import com.employee_mgr_server.domain.core.exceptions.ResourceCreationException;
import com.employee_mgr_server.domain.core.exceptions.ResourceNotFoundException;
import com.employee_mgr_server.domain.employee.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee) throws ResourceCreationException;
    Employee getById(Long id) throws ResourceNotFoundException;
    Employee getByEmail(String email) throws ResourceNotFoundException;
    List<Employee> getAll();

    Employee update(Long id, Employee employeeDetail) throws ResourceNotFoundException;
    void delete(Long id);
}