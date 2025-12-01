package com.luv2code.springboot.curddemo.dao;

import com.luv2code.springboot.curddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // that's it ... no need to write any code LOL!
}
