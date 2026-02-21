package com.lift.lift.controller;

import com.lift.lift.model.Employee;
import com.lift.lift.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmpController {

    @Autowired   //Setter-Injection for object creation
    EmployeeService employeeService;


    @GetMapping("/employee-data")
    public List<Employee> getEmpList() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employee-data/{employeeId}")
    public int getEmployeeFloor(@PathVariable int employeeId) {
        return employeeService.getEmployeeFloor(employeeId);
    }

    @PostMapping("/")
    public Employee addNewEmployee(@RequestBody Employee empDetails) {
        return employeeService.addNewEmployee(empDetails);
    }

    @PutMapping("/")
    public String updateFloor(@RequestBody Employee empNewDetails) {
        return employeeService.updateFloor(empNewDetails.getEmployeeID(), empNewDetails.getEmployeeFloor());
    }

    @DeleteMapping("/{empId}")
    public String removeEmployee(@PathVariable int empId) {
        return employeeService.removeEmployee(empId);
    }
}








//Object will be created for service before controller because controller needs service
//Constructor-Injection

//    private final EmployeeService employeeService;
//
//    EmpController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }