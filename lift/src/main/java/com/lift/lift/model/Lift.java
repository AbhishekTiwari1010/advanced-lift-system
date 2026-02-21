package com.lift.lift.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Scope("prototype")   // each request gives a NEW Lift
public class Lift {

    public int liftNumber;
    public ArrayList<Integer> listOfRequests;
    public int blockNo;
    public boolean isIdeal;
    public boolean isLocked;
    public long lastRequestTime; // track last request arrival
    public long firstRequestTime;





    public long getFirstRequestTime() {
        return firstRequestTime;
    }
    public void setFirstRequestTime(long firstRequestTime) {
        this.firstRequestTime = firstRequestTime;
    }




    public boolean getIsLocked() {
        return isLocked;
    }
    public void setIsLocked(boolean locked) {
        isLocked = locked;
    }



    public long getLastRequestTime() {
        return lastRequestTime;
    }
    public void setLastRequestTime(long lastRequestTime) {
        this.lastRequestTime = lastRequestTime;
    }



    public int getLiftNumber() {
        return liftNumber;
    }
    public void setLiftNumber(int liftNumber) {
        this.liftNumber = liftNumber;
    }



    public ArrayList<Integer> getListOfRequests() {
        return listOfRequests;
    }
    public void setListOfRequests(ArrayList listOfRequests) {
        this.listOfRequests = listOfRequests;
    }



    public int getBlockNo() {
        return blockNo;
    }
    public void setBlockNo(int blockNo) {
        this.blockNo = blockNo;
    }



    public boolean getIsIdeal() {
        return isIdeal;
    }
    public void setIsIdeal(boolean isIdeal) {
        this.isIdeal = isIdeal;
    }

}
