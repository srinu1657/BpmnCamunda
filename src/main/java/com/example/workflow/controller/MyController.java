package com.example.workflow.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/execute/{id}")
    public String  executeWorkflow(@PathVariable(name="id") String name){
        //First we have to get process enigne
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println("defaultProcessEngine"+defaultProcessEngine);
        //Get Run time service and make ready process instance
        ProcessInstantiationBuilder processInstance = defaultProcessEngine.getRuntimeService().createProcessInstanceByKey(name);
        System.out.println("processInstanceByKey"+processInstance);
        //Execute the process instance

        //we can use below variable in BPMN file
        String item="srini_123";
        processInstance.setVariable("case",item);

        //adding business key for bpmn. So bpmn file can understand that which was endpoint invoked me
        processInstance.businessKey("GR_1234567");

        processInstance.executeWithVariablesInReturn();
        return "BPMN file processed";
    }

}
