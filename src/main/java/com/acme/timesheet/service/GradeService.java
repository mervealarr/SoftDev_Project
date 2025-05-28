package com.acme.timesheet.service;

import com.acme.timesheet.domain.Grade;
import com.acme.timesheet.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    private final GradeRepository repo;
    public GradeService(GradeRepository repo) {
        this.repo = repo;
    }

    public List<Grade> findAll() {
        return repo.findAll();
    }

    public Grade save(Grade g) {
        return repo.save(g);
    }
}
