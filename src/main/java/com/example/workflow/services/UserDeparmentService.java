package com.example.workflow.services;

import org.springframework.stereotype.Component;

@Component
public class UserDeparmentService {
    public String getUserDeparmentService(){
        //Business logic
        System.out.println("getUserDeparmentService method");
        return "Accounts";
    }
}
