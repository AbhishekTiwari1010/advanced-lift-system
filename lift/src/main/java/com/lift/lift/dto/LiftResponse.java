package com.lift.lift.dto;


public class LiftResponse {
    private int empId;
    private int floorNumber;
    private Integer liftNumber;  // null if no lift available
    private String message;

    public LiftResponse(int empId, int floorNumber, Integer liftNumber, String message) {
        this.empId = empId;
        this.floorNumber = floorNumber;
        this.liftNumber = liftNumber;
        this.message = message;
    }



    // Getters and setters
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }


    public int getFloorNumber() {
        return floorNumber;
    }
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }


    public Integer getLiftNumber() {
        return liftNumber;
    }
    public void setLiftNumber(Integer liftNumber) {
        this.liftNumber = liftNumber;
    }


    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

