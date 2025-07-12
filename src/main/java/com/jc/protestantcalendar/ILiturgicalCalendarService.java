package com.jc.protestantcalendar;

import java.time.LocalDate;
import java.util.List;

public interface ILiturgicalCalendarService {
    LiturgicalWeek getLiturgicalWeekFor(LocalDate date);
    List<LiturgicalDay> getUpcomingFeasts(LocalDate fromDate, int count);
}
