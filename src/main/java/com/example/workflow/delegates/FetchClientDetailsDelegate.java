package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FetchClientDetailsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        //write business logic

        System.out.println("client details Delegate");
        //System.out.println(execution.getVariable("userObj1"));// global varaibles
        System.out.println(execution.getVariable("passToDelegate"));//input variables of service tasks
        execution.setVariable("email","srinu@gmail.com");
    }
}
