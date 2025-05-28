package com.acme.timesheet.service;

import com.acme.timesheet.domain.WorklogType;
import com.acme.timesheet.repository.WorklogTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorklogTypeService {
    private final WorklogTypeRepository repo;
    public WorklogTypeService(WorklogTypeRepository repo) {
        this.repo = repo;
    }

    public List<WorklogType> findAll() {
        return repo.findAll();
    }

    public WorklogType save(WorklogType t) {
        return repo.save(t);
    }
}
