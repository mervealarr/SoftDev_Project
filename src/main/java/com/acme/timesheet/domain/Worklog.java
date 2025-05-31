package com.acme.timesheet.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.YearMonth;

@Entity
@Table(name = "worklogs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Worklog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee engineer;

    private YearMonth monthDate;  // e.g. 2025-05

    @ManyToOne
    @JoinColumn(name = "type_id")
    private WorklogType type;

    private int effort;           // hours

    public Long getId() { return id; }
    public Employee getEngineer() { return engineer; }
    public void setEngineer(Employee engineer) { this.engineer = engineer; }
    public YearMonth getMonthDate() { return monthDate; }
    public void setMonthDate(YearMonth monthDate) { this.monthDate = monthDate; }
    public WorklogType getType() { return type; }
    public void setType(WorklogType type) { this.type = type; }
    public int getEffort() { return effort; }
    public void setEffort(int effort) { this.effort = effort; }
}
