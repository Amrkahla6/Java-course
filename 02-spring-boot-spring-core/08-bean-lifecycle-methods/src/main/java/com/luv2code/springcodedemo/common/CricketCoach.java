package com.luv2code.springcodedemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements CoachInterface{

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("in doMyStartupStuff()" + getClass().getSimpleName());
    }

    //Define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("in doMyCleanupStuff()" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
