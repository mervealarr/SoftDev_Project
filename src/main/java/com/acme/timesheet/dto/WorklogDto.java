package com.acme.timesheet.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class WorklogDto {
    @NotNull(message = "Employee ID boş olamaz")
    private IdDto employee;

    @NotNull(message = "Worklog Type ID boş olamaz")
    private IdDto type;

    @NotNull(message = "MonthDate boş olamaz")
    @Pattern(regexp = "\\d{4}-\\d{2}", message = "MonthDate formatı YYYY-MM olmalı")
    private String monthDate;

    @Min(value = 1, message = "Effort en az 1 saat olmalı")
    private int effort;

    // getter / setter
    public IdDto getEmployee() { return employee; }
    public void setEmployee(IdDto employee) { this.employee = employee; }

    public IdDto getType() { return type; }
    public void setType(IdDto type) { this.type = type; }

    public String getMonthDate() { return monthDate; }
    public void setMonthDate(String monthDate) { this.monthDate = monthDate; }

    public int getEffort() { return effort; }
    public void setEffort(int effort) { this.effort = effort; }
}

