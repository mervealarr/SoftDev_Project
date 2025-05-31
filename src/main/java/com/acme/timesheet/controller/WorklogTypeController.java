package com.acme.timesheet.controller;

import com.acme.timesheet.domain.WorklogType;
import com.acme.timesheet.service.WorklogTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worklog-types")
public class WorklogTypeController {
    private final WorklogTypeService svc;
    public WorklogTypeController(WorklogTypeService svc) { this.svc = svc; }

    @GetMapping
    public List<WorklogType> all() {
        return svc.findAll();
    }

    @PostMapping
    public WorklogType create(@RequestBody WorklogType t) {
        return svc.save(t);
    }
}
