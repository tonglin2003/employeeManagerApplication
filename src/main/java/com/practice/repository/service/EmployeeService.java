package com.practice.repository.service;

import com.practice.employeemanager.model.Employee;
import com.practice.repository.EmployeeRepo;
import com.practice.repository.exception.UserNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }


    // add to the database
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());

        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        // the save function, depends on the "id" section of the given object,
        // if "id" is empty, then it will be added into the table
        // but if "id" is not empty, then it will be treated as existing row in table
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(ObjectId id){
        employeeRepo.deleteById(id);
    }

    public Employee findEmployeeById(ObjectId id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + " is not found"));
    }


}
