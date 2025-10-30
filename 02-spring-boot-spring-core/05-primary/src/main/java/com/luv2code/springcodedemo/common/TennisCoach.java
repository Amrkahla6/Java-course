package com.luv2code.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements CoachInterface{
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
