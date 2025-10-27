package com.luv2code.springcodedemo.rest;

import com.luv2code.util.CoachInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private CoachInterface myCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(CoachInterface theCoach){
        myCoach = theCoach;
    }

    @GetMapping("dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
