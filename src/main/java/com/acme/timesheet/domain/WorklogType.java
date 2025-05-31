package com.acme.timesheet.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "worklog_types")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class WorklogType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
