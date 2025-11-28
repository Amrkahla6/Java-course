package com.luv2code.springboot.curddemo.rest;

import com.luv2code.springboot.curddemo.entity.Employee;
import com.luv2code.springboot.curddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    // quick and dirty: inject employee dao (use constructor injection)

    public EmployeeController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper) {
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee ID not found");
        }

        return  theEmployee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee){
       return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);

        return "Deleted Successfully";
    }

    // add mapping for PATCH /employees/{employeeId} - patch employee ... partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String,Object> patchPayload){
        Employee theEmployee = employeeService.findById(employeeId);

        // throw exception if null
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        // throw exception if request body contains "id" key
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = apply(patchPayload, theEmployee);

        return employeeService.save(patchedEmployee);
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee){
        // Convert employee object to a JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        // Convert the patchPayload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge the patch updates into the employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
