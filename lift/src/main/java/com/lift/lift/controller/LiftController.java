package com.lift.lift.controller;
import com.lift.lift.dto.LiftResponse;
import com.lift.lift.model.Lift;
import com.lift.lift.service.EmployeeServiceImpl;
import com.lift.lift.service.LiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lift")
public class LiftController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    LiftService liftService;

    @GetMapping("/{empId}")
    public ResponseEntity<LiftResponse> findEmployeeLift(@PathVariable int empId) {
        int floorNumber = employeeService.getEmployeeFloor(empId);
        //System.out.println("\n-------------" + empId + "  :  " + floorNumber);

        Lift liftAssigned = liftService.assignLiftToRequest(floorNumber);


        if (liftAssigned == null) {
            String msg =" ⚠️ All lifts busy... please wait.";
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(new LiftResponse(empId, floorNumber, null, msg));
        }


        String msg;
        if (liftAssigned.getListOfRequests().isEmpty()) {
            msg = "⚠️ Something went wrong, no request stored.";
        } else if (liftAssigned.getListOfRequests().size() >= 4) {
            msg = "✅ Lift " + liftAssigned.getLiftNumber() +
                    " full → Lift will start serving.";
        } else {
            msg = "✅ Assigned to Lift " + liftAssigned.getLiftNumber() +
                    " (waiting for more requests).";
        }

        return ResponseEntity.ok(new LiftResponse(empId, floorNumber, liftAssigned.getLiftNumber(), msg));
    }

}
