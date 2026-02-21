package com.lift.lift.service;

import com.lift.lift.model.Employee;
import com.lift.lift.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class EmployeeServiceImpl implements EmployeeService {

        @Autowired
        private EmployeeRepo employeeRepo;


        @Override
        public List<Employee> getAllEmployee() {
            // Retrieves and returns a list of all department entities.
            return (List<Employee>) employeeRepo.findAll();
        }

        @Override
        public int getEmployeeFloor(int employeeID) {
            Employee employeeDB = employeeRepo.findById(employeeID).get();
            return employeeDB.getEmployeeFloor();
        }


        @Override
        public Employee addNewEmployee(Employee employee) {
            // Saves and returns the department entity.
            return employeeRepo.save(employee);

        }


        @Override
        public String updateFloor(int employeeID, int employeeNewFloor) {
            Employee employeeDB = employeeRepo.findById(employeeID).get(); // Finds the existing Floor by ID.

            employeeDB.setEmployeeFloor(employeeNewFloor);

            employeeRepo.save(employeeDB);  // Saves and returns the updated department entity.
            return "Employee " + employeeID + " floor has been updated to " + employeeNewFloor;
        }

        @Override
        public String removeEmployee(int employeeId) {
            // Deletes the department entity by its ID.
            employeeRepo.deleteById(employeeId);
            return "Employee " + employeeId + " has been deleted";
        }
    }


//            if (employeeRepo.existsById(employee.getEmployeeID())) {
//                throw new RuntimeException("Employee ID already exists: " + employee.getEmployeeID());
//            }
//            return employeeRepo.save(employee);