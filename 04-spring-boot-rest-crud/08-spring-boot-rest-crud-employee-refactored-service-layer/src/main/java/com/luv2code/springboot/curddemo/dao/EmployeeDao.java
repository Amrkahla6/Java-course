package com.luv2code.springboot.curddemo.dao;

import com.luv2code.springboot.curddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

}
