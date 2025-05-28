package com.acme.timesheet.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grades")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Grade {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;   // Engineer, Senior Engineer…
}
