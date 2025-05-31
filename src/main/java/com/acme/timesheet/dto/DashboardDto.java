package com.acme.timesheet.dto;

import java.util.List;

public class DashboardDto {
    private List<StatDto> byEmployee;
    private List<StatDto> byTeamLead;
    private List<StatDto> byDirector;
    // bu alttaki iki yeni
    private List<StatDto> byGrade;
    private List<StatDto> byWorklogType;

    public DashboardDto(List<StatDto> byEmployee, List<StatDto> byTeamLead, List<StatDto> byDirector) {
        this.byEmployee = byEmployee;
        this.byTeamLead = byTeamLead;
        this.byDirector = byDirector;
    }
    public DashboardDto(List<StatDto> byEmployee, List<StatDto> byTeamLead, List<StatDto> byDirector,
                        List<StatDto> byGrade, List<StatDto> byWorklogType) {
        this.byEmployee = byEmployee;
        this.byTeamLead = byTeamLead;
        this.byDirector = byDirector;
        this.byGrade = byGrade;
        this.byWorklogType = byWorklogType;
    }

    public List<StatDto> getByEmployee() {
        return byEmployee;
    }

    public List<StatDto> getByTeamLead() {
        return byTeamLead;
    }

    public List<StatDto> getByDirector() {
        return byDirector;
    }

    public List<StatDto> getByGrade() {
        return byGrade;
    }

    public List<StatDto> getByWorklogType() {
        return byWorklogType;
    }

}
