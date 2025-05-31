package com.acme.timesheet.dto;

import java.util.List;

public class StatDto {
    private String label;
    private long totalEffort;
    private List<StatDto> children;

    public StatDto() {}

    public StatDto(String label, long totalEffort) {
        this.label = label;
        this.totalEffort = totalEffort;
    }

    public StatDto(String label, long totalEffort, List<StatDto> children) {
        this.label = label;
        this.totalEffort = totalEffort;
        this.children = children;
    }

    public String getLabel() {
        return label;
    }

    public long getTotalEffort() {
        return totalEffort;
    }

    public List<StatDto> getChildren() {
        return children;
    }

    public void setChildren(List<StatDto> children) {
        this.children = children;
    }
}
