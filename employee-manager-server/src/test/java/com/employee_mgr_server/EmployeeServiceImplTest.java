package com.employee_mgr_server;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.employee_mgr_server.domain.core.exceptions.ResourceCreationException;
import com.employee_mgr_server.domain.core.exceptions.ResourceNotFoundException;
import com.employee_mgr_server.domain.employee.models.Employee;
import com.employee_mgr_server.domain.employee.repos.EmployeeRepository;
import com.employee_mgr_server.domain.employee.services.EmployeeServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
class EmployeeServiceImplTest {

    private EmployeeRepository employeeRepository;
    private EmployeeServiceImpl employeeService;
    private Employee employee;

    @BeforeEach
void setUp() {
    employeeRepository = Mockito.mock(EmployeeRepository.class);
    employeeService = new EmployeeServiceImpl(employeeRepository);
    employee = new Employee(1L, "John", "Doe", "john.doe@example.com");
}

    @Test
    void testGetAllEmployees(){
        
    }

    @Test
    void testEmployeeEmailAlreadyExists() {
        
        when(employeeRepository.findByEmail(employee.getEmail())).thenReturn(Optional.of(employee));

        ResourceCreationException exception = assertThrows(ResourceCreationException.class, () -> {
            employeeService.create(employee);
        });

        assertEquals("Employee with email exists: john.doe@example.com", exception.getMessage());
        verify(employeeRepository, times(1)).findByEmail(employee.getEmail());
    }

    @Test
    void testCreateEmployee() throws ResourceCreationException {
        when(employeeRepository.findByEmail(employee.getEmail())).thenReturn(Optional.empty());
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee createdEmployee = employeeService.create(employee);

        assertNotNull(createdEmployee);
        assertEquals(employee.getEmail(), createdEmployee.getEmail());
        verify(employeeRepository, times(1)).findByEmail(employee.getEmail());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testGetEmployeeById() throws ResourceNotFoundException {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee foundEmployee = employeeService.getById(1L);

        assertNotNull(foundEmployee);
        assertEquals(employee.getId(), foundEmployee.getId());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void testEmployeeNotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.getById(1L);
        });

        assertEquals("No Employee with id: 1", exception.getMessage());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void testGetEmployeeByEmail() throws ResourceNotFoundException {
        when(employeeRepository.findByEmail("john.doe@example.com")).thenReturn(Optional.of(employee));

        Employee foundEmployee = employeeService.getByEmail("john.doe@example.com");

        assertNotNull(foundEmployee);
        assertEquals(employee.getEmail(), foundEmployee.getEmail());
        verify(employeeRepository, times(1)).findByEmail("john.doe@example.com");
    }

    @Test
    void testEmployeeEmailNonExistent() {
        when(employeeRepository.findByEmail("john.doe@example.com")).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.getByEmail("john.doe@example.com");
        });

        assertEquals("No Employee with email: john.doe@example.com", exception.getMessage());
        verify(employeeRepository, times(1)).findByEmail("john.doe@example.com");
    }

    @Test
    void testUpdateEmployee() throws ResourceNotFoundException {
        Employee updatedEmployee = new Employee("John", "Smith", "john.smith@example.com");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(updatedEmployee)).thenReturn(updatedEmployee);

        Employee result = employeeService.update(1L, updatedEmployee);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Smith", result.getLastName());
        assertEquals("john.smith@example.com", result.getEmail());
        verify(employeeRepository, times(1)).findById(1L);
        verify(employeeRepository, times(1)).save(updatedEmployee);
    }

    @Test
    void testUpdateEmployee_whenEmployeeNotFound_shouldThrowException() {
        Employee updatedEmployee = new Employee( "John", "Smith", "john.smith@example.com");
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.update(1L, updatedEmployee);
        });

        assertEquals("No Employee with id: 1", exception.getMessage());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteEmployee() throws ResourceNotFoundException {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        employeeService.delete(1L);

        verify(employeeRepository, times(1)).findById(1L);
        verify(employeeRepository, times(1)).delete(employee);
    }

    @Test
    void testDeleteEmployee_whenEmployeeNotFound_shouldThrowException() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.delete(1L);
        });

        assertEquals("No Employee with id: 1", exception.getMessage());
        verify(employeeRepository, times(1)).findById(1L);
    }
    @Test
    void testEmployeeToAString(){
        String result = employee.toString();
        String expected = "1 John Doe john.doe@example.com";
        assertEquals(expected, result);
    }
}
