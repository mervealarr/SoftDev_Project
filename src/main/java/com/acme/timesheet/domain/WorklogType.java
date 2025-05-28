package com.acme.timesheet.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "worklog_types")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class WorklogType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;   // Development, Analysis, Test…
}
