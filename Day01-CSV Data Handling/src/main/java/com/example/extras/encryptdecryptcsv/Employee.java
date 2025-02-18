package com.example.extras.encryptdecryptcsv;

import com.opencsv.*;
import java.io.*;
import java.util.*;

public class Employee {
    String id;
    String name;
    String email;
    String salary;

    // Constructor
    public Employee(String id, String name, String email, String salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // toString for printing
    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', email='" + email + "', salary='" + salary + "'}";
    }

    // Method to convert Employee object to CSV string
    public String toCSVString() {
        return id + "," + name + "," + email + "," + salary;
    }

    // Static method to create Employee from CSV String
    public static Employee fromCSVString(String csv) {
        String[] fields = csv.split(",");
        return new Employee(fields[0], fields[1], fields[2], fields[3]);
    }
}