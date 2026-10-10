package com.anurag.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class demo {

    @GetMapping("/")
    public String home() {
        return "College Attendance System Backend is Running!";
    }

    @GetMapping("/ecee")
    public Employee getEmployee() {
        return new Employee(
            "Akki",
            "12345678",
            "akki@email.com",
            "ECE",
            "3rd Year"
        );
    }

    @GetMapping("/name")
    public String getName() {
        return "Akshaya";
    }

    @GetMapping("/roll")
    public String getRoll() {
        return "24eg104e27";
    }
}
