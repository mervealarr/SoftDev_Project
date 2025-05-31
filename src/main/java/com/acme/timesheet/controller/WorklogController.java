package com.acme.timesheet.controller;

import com.acme.timesheet.domain.Worklog;
import com.acme.timesheet.dto.WorklogDto;
import com.acme.timesheet.service.WorklogService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.acme.timesheet.dto.DashboardDto;


import jakarta.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/worklogs")
@Validated
public class WorklogController {

    private final WorklogService service;

    public WorklogController(WorklogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Worklog> create(@Valid @RequestBody WorklogDto dto) {
        Worklog saved = service.createWorklog(dto);
        URI location = URI.create("/api/worklogs/" + saved.getId());
        return ResponseEntity.created(location).body(saved);
    }

    @GetMapping("/dashboard")
    public DashboardDto getDashboard() {
        return service.getDashboard();
    }



}
