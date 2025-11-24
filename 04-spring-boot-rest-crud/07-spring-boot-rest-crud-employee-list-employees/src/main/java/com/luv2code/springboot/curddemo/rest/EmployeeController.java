package com.luv2code.springboot.curddemo.rest;

import com.luv2code.springboot.curddemo.dao.EmployeeDao;
import com.luv2code.springboot.curddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeDao employeeDao;

    // quick and dirty: inject employee dao (use constructor injection)

    public EmployeeController(EmployeeDao theEmployeeDAO) {
        employeeDao = theEmployeeDAO;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }
}
