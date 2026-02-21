package com.lift.lift.service;

import com.lift.lift.model.Lift;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class LiftServeService {

    public void serveTheLift(Lift lift) {
        List<Integer> listOfRequests = lift.getListOfRequests();
        Collections.sort(listOfRequests);

        System.out.println("Lift " + lift.getLiftNumber() + " start serving");
        int floorNo = 0;

        while(!listOfRequests.isEmpty() && floorNo<=listOfRequests.getLast()) {
            int gateOpenedFor = 0;

            if(floorNo == listOfRequests.getFirst()) {
                gateOpenedFor = 7; //Expected time for a user to come out from a lift
                listOfRequests.removeFirst();

                //Add 3sec for every other user of the same floor
                while(!listOfRequests.isEmpty() && floorNo == listOfRequests.getFirst()) {
                    gateOpenedFor += 3;
                    floorNo++;
                    listOfRequests.removeFirst();

                    if(floorNo == listOfRequests.getLast()) {
                        System.out.println("---------lift" + lift.getLiftNumber() + " service completed---------\n\n");
                    }
                }

                System.out.println("\nlift" + lift.getLiftNumber() +" Gate Opened : " + floorNo);
                try {
                    Thread.sleep(gateOpenedFor* 1000L);
                    System.out.println("lift" + lift.getLiftNumber() + " Gate Closed------\n");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                if (listOfRequests.isEmpty()) {
                    System.out.println("---------Lift " + lift.getLiftNumber() + " service completed---------\n\n");
                }
            }

            else {
                System.out.println(floorNo + " continue");
            }
        floorNo++;
        }
    }
}
