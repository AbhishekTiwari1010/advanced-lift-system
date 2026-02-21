package com.lift.lift.model;
import jakarta.persistence.*;

@Entity
@Table(name = "employeeinfo")
public class Employee {

    @Id
    private int employeeID;

    @Column(name = "employeeFloor", nullable = false)
    private int employeeFloor;



    public int getEmployeeFloor() {
        return employeeFloor;
    }
    public void setEmployeeFloor(int employeeFloor) {
        this.employeeFloor = employeeFloor;
    }


    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}

