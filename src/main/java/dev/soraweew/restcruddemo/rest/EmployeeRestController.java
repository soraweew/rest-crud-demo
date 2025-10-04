package dev.soraweew.restcruddemo.rest;

import dev.soraweew.restcruddemo.entity.Employee;
import dev.soraweew.restcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {

        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee is not found - " + id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // Force a save of new item instead of update for the behavior of Entity Manager's merge
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        Employee dbEmployee = employeeService.save(employee);

        return employee;
    }
}
