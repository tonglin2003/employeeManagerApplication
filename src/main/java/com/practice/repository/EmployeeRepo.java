package com.practice.repository;

import com.practice.employeemanager.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

// MongoRepository<Employee, ObjectId>
// Employee is the model class
// ObjectId is the type of the id of the model class
public interface EmployeeRepo extends MongoRepository<Employee, ObjectId> {
    @Query("{name:'?0'}")
    Employee findEmployeeByName(String name);

    @Query(value="{jobTitle:'?0'}", fields = "{'name': 1}")
    List<Employee> findAllJobTitle(String jobTitle);

    @Query(value = "{employeeCode: '?0'}")
    Employee findEmployeeByEmployeeCode(String employeeCode);

    List<Employee> findAll();

    public long count();


    @Query(value="{id: '?0'}")
    Optional<Employee> findEmployeeById(ObjectId id);
}
