package com.acme.timesheet.controller;

import com.acme.timesheet.domain.Employee;
import com.acme.timesheet.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService svc;
    public EmployeeController(EmployeeService svc) { this.svc = svc; }

    @GetMapping
    public List<Employee> all() { return svc.findAll(); }

    @PostMapping
    public Employee create(@RequestBody Employee e) { return svc.save(e); }
}
