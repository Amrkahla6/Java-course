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
    private CoachInterface anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") CoachInterface theCoach,
            @Qualifier("cricketCoach") CoachInterface theAnotherCoach
    ){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
