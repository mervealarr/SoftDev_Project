package com.acme.timesheet.repository;

import com.acme.timesheet.domain.WorklogType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorklogTypeRepository extends JpaRepository<WorklogType, Long> {
}
