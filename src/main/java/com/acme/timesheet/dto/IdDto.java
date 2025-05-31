package com.acme.timesheet.dto;

import jakarta.validation.constraints.NotNull;

public class IdDto {
    @NotNull
    private Long id;

    public IdDto() {}

    public IdDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

