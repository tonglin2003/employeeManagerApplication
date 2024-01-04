package com.practice.employeemanager.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

// make sure this will be mapped into a database with your choice
@Document(collection = "employee")
public class Employee implements Serializable {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imgUrl;

    private String employeeCode;

    public Employee(String name, String email, String jobTitle, String phone, String imgUrl, String employeeCode){
        super();
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imgUrl = imgUrl;
        this.employeeCode = employeeCode;
    }

    public Employee() {

    }


    public ObjectId getId(){return id;}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString(){
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }

}
