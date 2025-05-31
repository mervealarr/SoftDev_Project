package com.acme.timesheet.controller;

import com.acme.timesheet.domain.Grade;
import com.acme.timesheet.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    private final GradeService svc;
    public GradeController(GradeService svc) { this.svc = svc; }

    @GetMapping
    public List<Grade> all() {
        return svc.findAll();
    }

    @PostMapping
    public Grade create(@RequestBody Grade g) {
        return svc.save(g);
    }
}
