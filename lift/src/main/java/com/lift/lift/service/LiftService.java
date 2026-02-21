package com.lift.lift.service;

import com.lift.lift.model.Lift;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
public class LiftService {

    private final Lift[] lifts = new Lift[2];

    @Autowired
    private ObjectFactory<Lift> liftFactory;  // lets Spring create new objects

    @Autowired
    LiftServeService liftServeService;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

    @PostConstruct
    public void init() {
        for (int i = 0; i < 2; i++) {
            lifts[i] = liftFactory.getObject();
            lifts[i].setLiftNumber(i + 1);
            lifts[i].setListOfRequests(new ArrayList<>());
            lifts[i].setIsIdeal(true);
            lifts[i].setBlockNo(-1);
            lifts[i].setIsLocked(false);
            lifts[i].setLastRequestTime(0L);
        }
    }


    public Lift assignLiftToRequest(int floorNo) {
        int block = floorNo/10;

        for(Lift lift : lifts) {
            //If a lift has already assigned to this block
            if(!lift.getIsIdeal() && lift.getBlockNo() == block && !lift.getIsLocked()) {
                lift.getListOfRequests().add(floorNo);
                lift.setLastRequestTime(System.currentTimeMillis());
                System.out.println("Lift" + lift.getLiftNumber() + " get request floorNo :  " + floorNo +
                        " [" + (Math.abs(lift.getFirstRequestTime()-lift.getLastRequestTime())/1000) + "sec]");

                if (lift.getListOfRequests().size() >= 4) {
                    lift.setIsLocked(true);  //lock->no more request
                    lockAndGraceWait(lift);
                }
                else {
                    scheduleServing(lift);
                }
                return lift;
            }
        }


        // Assign a new lift if available
        for (Lift lift : lifts) {
            if (lift.getIsIdeal() && !lift.getIsLocked()) {
                lift.setIsIdeal(false);
                lift.setBlockNo(block);
                lift.getListOfRequests().add(floorNo);
                lift.setLastRequestTime(System.currentTimeMillis());
                lift.setFirstRequestTime(System.currentTimeMillis());
                System.out.println("\nLift"+lift.getLiftNumber() + " get 1st request floorNo: " + floorNo +
                        " [" + (Math.abs(lift.getFirstRequestTime()-lift.getLastRequestTime())/1000) + "sec]");
                scheduleServing(lift);
                return lift;
            }
        }
        return null; // No lift available
    }



    public void serveLift(Lift lift) {
        Collections.sort(lift.getListOfRequests());
        System.out.println("Lift" + lift.getLiftNumber() + " Start serving for.....  : " + lift.getListOfRequests());
        liftServeService.serveTheLift(lift);
        //lift.getListOfRequests().clear();  //In ServeService, lift already became empty
        lift.setIsIdeal(true);
        lift.setIsLocked(false);
        lift.setBlockNo(-1);
    }


    public void scheduleServing(Lift lift) {
        scheduler.schedule(() -> {
            long difference = System.currentTimeMillis() - lift.getLastRequestTime();
           // System.out.println("\nWaiting Time for lift"+ lift.getLiftNumber() + " : " + difference/1000);

            if (difference >= 20000 && !lift.getListOfRequests().isEmpty() && !lift.getIsLocked()) {
                System.out.println("Lift" + lift.getLiftNumber() + " get TIMED-OUT");
                serveLift(lift);
            }
            else if (!lift.getIsIdeal() && !lift.getIsLocked()) {
                // only reschedule if lift is still working
                scheduleServing(lift);
            }
        }, 20, TimeUnit.SECONDS);
    }


    // Case B: FULL → lock and wait 10s, then serve
    private void lockAndGraceWait(Lift lift) {
        scheduler.schedule(() -> {
            if (lift.getIsLocked()) {
                System.out.println("Lift" + lift.getLiftNumber() + " get Full");
                serveLift(lift);
            }
        }, 10, TimeUnit.SECONDS);
    }
}
