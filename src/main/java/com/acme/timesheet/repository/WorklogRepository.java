package com.acme.timesheet.repository;

import com.acme.timesheet.domain.Worklog;
import org.springframework.data.jpa.repository.JpaRepository;
import com.acme.timesheet.dto.StatDto;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface WorklogRepository extends JpaRepository<Worklog, Long> {
    @Query("""
    SELECT new com.acme.timesheet.dto.StatDto(
      CONCAT(w.engineer.firstName, ' ', w.engineer.lastName),
      SUM(w.effort)
    )
    FROM Worklog w
    GROUP BY w.engineer.firstName, w.engineer.lastName
  """)
    List<StatDto> sumEffortByEmployee();

    @Query("""
    SELECT new com.acme.timesheet.dto.StatDto(
      w.engineer.teamLead,
      SUM(w.effort)
    )
    FROM Worklog w
    GROUP BY w.engineer.teamLead
  """)
    List<StatDto> sumEffortByTeamLead();

    @Query("""
    SELECT new com.acme.timesheet.dto.StatDto(
      w.engineer.director,
      SUM(w.effort)
    )
    FROM Worklog w
    GROUP BY w.engineer.director
  """)
    List<StatDto> sumEffortByDirector();
    // yeni alttaki iki
    @Query("""
    SELECT new com.acme.timesheet.dto.StatDto(
      w.engineer.grade.name,
      SUM(w.effort)
    )
    FROM Worklog w
    GROUP BY w.engineer.grade.name
  """)
    List<StatDto> sumEffortByGrade();

    @Query("""
    SELECT new com.acme.timesheet.dto.StatDto(
      w.type.name,
      SUM(w.effort)
    )
    FROM Worklog w
    GROUP BY w.type.name
  """)
    List<StatDto> sumEffortByWorklogType();
}
