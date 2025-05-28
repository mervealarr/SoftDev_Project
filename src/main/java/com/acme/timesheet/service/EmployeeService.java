package com.acme.timesheet.service;

import com.acme.timesheet.domain.Employee;
import com.acme.timesheet.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo) { this.repo = repo; }

    public List<Employee> findAll() { return repo.findAll(); }
    public Employee save(Employee e) { return repo.save(e); }
}
