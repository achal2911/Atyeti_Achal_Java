package org.example.employeemanagementsystem_practice.service;

import com.example.entity.Employee;
import com.example.exception.EmployeeNotFoundException;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    private EmployeeRepository repository;
    private EmployeeService service;

    @BeforeEach
    public void setup() {
        repository = mock(EmployeeRepository.class);
        service = new EmployeeService(repository);
    }

    @Test
    public void testAddEmployee_Success() {
        Employee emp = new Employee();
        emp.setName("Shoheb");
        emp.setEmail("shoheb@example.com");
        emp.setDepartment("IT");

        when(repository.save(emp)).thenReturn(emp);

        Employee saved = service.addEmployee(emp);

        assertNotNull(saved);
        assertEquals("Shoheb", saved.getName());
    }

    @Test
    public void testAddEmployee_ThrowsException_WhenFieldsNull() {
        Employee emp = new Employee(); // all fields are null

        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.addEmployee(emp));
        assertEquals("Employee details cannot be null", ex.getMessage());
    }

    @Test
    public void testGetEmployeeById_Success() {
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("Shoheb");
        emp.setEmail("shoheb@example.com");
        emp.setDepartment("IT");

        when(repository.findById(1L)).thenReturn(Optional.of(emp));

        Employee result = service.getEmployee(1L);
        assertEquals("Shoheb", result.getName());
    }

    @Test
    public void testGetEmployeeById_NotFound() {
        when(repository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(EmployeeNotFoundException.class, () -> service.getEmployee(2L));
    }

    @Test
    public void testGetAllEmployees_Success() {
        Employee emp1 = new Employee();
        emp1.setName("A");

        Employee emp2 = new Employee();
        emp2.setName("B");

        when(repository.count()).thenReturn(2L);
        when(repository.findAll()).thenReturn(Arrays.asList(emp1, emp2));

        List<Employee> all = service.getAllEmployees();
        assertEquals(2, all.size());
    }

    @Test
    public void testGetAllEmployees_EmptyList_ThrowsException() {
        when(repository.count()).thenReturn(0L);
        assertThrows(EmployeeNotFoundException.class, () -> service.getAllEmployees());
    }

    @Test
    public void testUpdateEmployee_Success() {
        Employee oldEmp = new Employee();
        oldEmp.setId(1L);
        oldEmp.setName("Old");

        Employee newEmp = new Employee();
        newEmp.setName("New Name");
        newEmp.setEmail("new@email.com");
        newEmp.setDepartment("HR");

        when(repository.findById(1L)).thenReturn(Optional.of(oldEmp));
        when(repository.save(any(Employee.class))).thenReturn(oldEmp);

        Employee updated = service.updateEmployee(1L, newEmp);
        assertEquals("New Name", updated.getName());
    }

    @Test
    public void testUpdateEmployee_NotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        Employee dummy = new Employee();
        assertThrows(EmployeeNotFoundException.class, () -> service.updateEmployee(99L, dummy));
    }

    @Test
    public void testDeleteEmployee_Success() {
        Employee emp = new Employee();
        emp.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(emp));
        doNothing().when(repository).deleteById(1L);

        service.deleteEmployee(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteEmployee_NotFound() {
        when(repository.findById(100L)).thenReturn(Optional.empty());

        assertThrows(EmployeeNotFoundException.class, () -> service.deleteEmployee(100L));
    }
}
