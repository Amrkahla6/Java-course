package com.luv2code.springcodedemo.rest;

import com.luv2code.springcodedemo.common.CoachInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private CoachInterface myCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") CoachInterface theCoach){
        myCoach = theCoach;
    }

    @GetMapping("dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
