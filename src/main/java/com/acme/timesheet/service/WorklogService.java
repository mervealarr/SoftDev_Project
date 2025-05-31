package com.acme.timesheet.service;

import com.acme.timesheet.domain.Employee;
import com.acme.timesheet.domain.Worklog;
import com.acme.timesheet.domain.WorklogType;
import com.acme.timesheet.dto.DashboardDto;
import com.acme.timesheet.dto.StatDto;
import com.acme.timesheet.dto.WorklogDto;
import com.acme.timesheet.repository.EmployeeRepository;
import com.acme.timesheet.repository.WorklogRepository;
import com.acme.timesheet.repository.WorklogTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.YearMonth;
import java.util.List;

@Service
public class WorklogService {

    private final WorklogRepository worklogRepo;
    private final EmployeeRepository employeeRepo;
    private final WorklogTypeRepository typeRepo;

    public WorklogService(WorklogRepository worklogRepo,
                          EmployeeRepository employeeRepo,
                          WorklogTypeRepository typeRepo) {
        this.worklogRepo = worklogRepo;
        this.employeeRepo = employeeRepo;
        this.typeRepo = typeRepo;
    }

    public Worklog createWorklog(WorklogDto dto) {
        Employee emp = employeeRepo.findById(dto.getEmployee().getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Geçersiz employee ID: " + dto.getEmployee().getId()
                ));

        WorklogType wt = typeRepo.findById(dto.getType().getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Geçersiz worklog type ID: " + dto.getType().getId()
                ));

        Worklog w = new Worklog();
        w.setEngineer(emp);
        w.setType(wt);
        w.setEffort(dto.getEffort());
        w.setMonthDate(YearMonth.parse(dto.getMonthDate()));

        return worklogRepo.save(w);
    }


    public DashboardDto getDashboard() {
        List<StatDto> byEmp = worklogRepo.sumEffortByEmployee();
        List<StatDto> byLead = worklogRepo.sumEffortByTeamLead();
        List<StatDto> byDirector = worklogRepo.sumEffortByDirector();

        // Çalışanları children olarak ekledim
        for (StatDto lead : byLead) {
            List<StatDto> teamMembers = byEmp.stream()
                    .filter(emp -> {
                        String[] parts = emp.getLabel().split(" ");
                        if (parts.length < 2) return false;
                        return employeeRepo.findByFirstNameAndLastName(parts[0], parts[1])
                                .map(realEmp -> realEmp.getTeamLead() != null && realEmp.getTeamLead().equals(lead.getLabel()))
                                .orElse(false);
                    })
                    .toList();
            lead.setChildren(teamMembers);
        }

        // Team lead’leri children olarak ekledim
        for (StatDto director : byDirector) {
            List<StatDto> leads = byLead.stream()
                    .filter(lead -> employeeRepo.findByFirstName(lead.getLabel())
                            .map(emp -> emp.getDirector() != null && emp.getDirector().equals(director.getLabel()))
                            .orElse(false)
                    ).toList();
            director.setChildren(leads);
        }


        List<StatDto> byGrade = worklogRepo.sumEffortByGrade();
        List<StatDto> byWorklogType = worklogRepo.sumEffortByWorklogType();

        return new DashboardDto(byEmp, byLead, byDirector, byGrade, byWorklogType);
    }


}
