package com.practice.repository.exception;

import com.practice.employeemanager.model.Employee;
import org.bson.types.ObjectId;

import java.util.Optional;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);

    }
}
