package com.practice.repository;

import com.practice.employeemanager.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
    @Query("{name:'?0'}")
    Employee findEmployeeByName(String name);

    @Query(value="{jobTitle:'?0'}", fields = "{'name': 1}")
    List<Employee> findAllJobTitle(String jobTitle);

    @Query(value = "{employeeCode: '?0'}")
    Employee findEmployeeByEmployeeCode(String employeeCode);

    List<Employee> findAll();

    public long count();


}
