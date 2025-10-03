package dev.soraweew.restcruddemo.dao;

import dev.soraweew.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
