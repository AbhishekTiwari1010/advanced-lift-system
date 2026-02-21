package com.lift.lift.service;

import com.lift.lift.model.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployee();

    int getEmployeeFloor(int id);

    Employee addNewEmployee(Employee emp);

    String updateFloor(int employeeID, int employeeNewFloor);

    String removeEmployee(int employeeID);
}
