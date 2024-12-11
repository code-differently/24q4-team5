package com.employee_mgr_server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee_mgr_server.domain.employee.models.Employee;

class EmployeeTest {

    private Employee employee;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @BeforeEach
    void setUp() {
        employee = new Employee("John", "Doe", "john.doe@example.com");
        employee1 = new Employee("Jon", "Doe", "jon.doe@example.com");
        employee2 = new Employee("Jon", "Doe", "jon.doe@example.com");
        employee3 = new Employee("Jane", "Smith", "jane.smith@example.com");
    }

    @Test
    void testEmployeeConstructor() {
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("john.doe@example.com", employee.getEmail());
    }

    @Test
    void testEmployeeIdNullByDefault() {
        assertNull(employee.getId());
    }

    @Test
    void testEmployeeSetters() {
        employee.setFirstName("Jane");
        employee.setLastName("Smith");
        employee.setEmail("jane.smith@example.com");

        assertEquals("Jane", employee.getFirstName());
        assertEquals("Smith", employee.getLastName());
        assertEquals("jane.smith@example.com", employee.getEmail());
    }

    @Test
    void testToString() {
        employee.setId(1L);
        String expectedToString = "1 John Doe john.doe@example.com";
        assertEquals(expectedToString, employee.toString());
    }

    @Test
    void testNonNullFirstName() {
        assertThrows(NullPointerException.class, () -> new Employee(null, "Doe", "john.doe@example.com"));
    }

    @Test
    void testNonNullLastName() {
        assertThrows(NullPointerException.class, () -> new Employee("John", null, "john.doe@example.com"));
    }

    @Test
    void testNonNullEmail() {
        assertThrows(NullPointerException.class, () -> new Employee("John", "Doe", null));
    }
    @Test
    void testHashCodeConsistency() {
        int hashCode1 = employee1.hashCode();
        int hashCode2 = employee1.hashCode();
        assertEquals(hashCode1, hashCode2, "hashCode should be consistent for the same object");
    }

    @Test
    void testHashCodeEquality() {
        assertEquals(employee1.hashCode(), employee2.hashCode(), "Equal objects should have the same hashCode");
    }

    @Test
    void testHashCodeInequality() {
        assertNotEquals(employee1.hashCode(), employee3.hashCode(), "Different objects should have different hashCodes");
    }
}



