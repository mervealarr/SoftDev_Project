package com.acme.timesheet.service;

import com.acme.timesheet.domain.Worklog;
import com.acme.timesheet.repository.WorklogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorklogService {
    private final WorklogRepository repo;
    public WorklogService(WorklogRepository repo) {
        this.repo = repo;
    }

    public List<Worklog> findAll() {
        return repo.findAll();
    }

    public Worklog save(Worklog w) {
        return repo.save(w);
    }
}
