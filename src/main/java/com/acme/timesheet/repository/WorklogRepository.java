package com.acme.timesheet.repository;

import com.acme.timesheet.domain.Worklog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorklogRepository extends JpaRepository<Worklog, Long> {
}
