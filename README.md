# Advanced Lift Management System

# Overview 
This is a Spring Boot application, It's A smart elevator scheduling system 
built using **Java** and **Spring Boot**, designed to efficiently manage 
multiple lifts based on user floor requests, timing logic, and optimization strategies.

# Project Structure
store-billing-app
│── src
│   ├── main
│   │   ├── java/com/lift/lift
│   │   │   ├── controller
│   │   │   │    ├──EmpController.java
│   │   │   │    ├──LiftController.java
│   │   │   ├── service
│   │   │   │    ├── EmployeeServiceImpl
│   │   │   │    ├── LiftServeServiceImpl
│   │   │   │    ├── LiftServiceImpl
│   │   │   ├── repo
│   │   │   │    ├── EmployeeRepo
│   │   │   │    ├── EmpRepo
│   │   │   ├── model
│   │   │   │    ├── Employee
│   │   │   │    ├── Lift
│   │   │   ├── dto
│   │   │   │    ├── LiftResponse
│   │   │   ├── LiftApplication
│   ├── resources
│   │   ├── application.properties
│── pom.xml
│── README.md


## Prerequisites
    * Java 17+
    * Maven
    * IntelliJ IDEA (or any Java IDE)


## Setup and Running the Application
   # Clone the repository:
     1. git clone https://https://github.com/AbhishekTiwari1010/advanced-lift-system.git
        cd advanced-lift-system

   # Build the project:
     2. mvn clean install

   # Run the application:
     3. mvn spring-boot:run

   # The server will start at: http://localhost:8081
   

## API Endpoints
  # Calculate Payable Amount
   
    ** Endpoint:
      POST /emplopyee

    ** Request Body Example:
        {
         "employeeID": 23,
         "employeeFloor": 32
        }

    

## Running Tests
     * Execute unit tests:
       mvn test

     * mvn testRun integration tests:
       mvn verify



```Security
The application uses a secret key stored in application.properties for authentication and security purposes
```

## Author

## Developed Abhishek Tiwari.
