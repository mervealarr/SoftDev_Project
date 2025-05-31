package com.acme.timesheet.service;

import com.acme.timesheet.domain.Employee;
import com.acme.timesheet.domain.Grade;
import com.acme.timesheet.repository.EmployeeRepository;
import com.acme.timesheet.repository.GradeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    private final GradeRepository gradeRepo;

    // İki repo’yu da constructor ile inject ediyoruz
    public EmployeeService(EmployeeRepository repo, GradeRepository gradeRepo) {
        this.repo      = repo;
        this.gradeRepo = gradeRepo;
    }

    public List<Employee> findAll() {
        return repo.findAll();
    }

    public Employee save(Employee e) {

        Long gradeId = e.getGrade().getId();


        Grade g = gradeRepo.findById(gradeId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Geçersiz grade ID: " + gradeId
                        )
                );

        // Gerçek Grade’i Employee’e set ettim
        e.setGrade(g);

        return repo.save(e);
    }
}
