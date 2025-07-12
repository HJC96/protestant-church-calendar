package com.jc.protestantcalendar;

import java.time.LocalDate;
import java.util.List;

public interface ILiturgicalCalendarService {
    List<LiturgicalDay> calculate(int year);
    LiturgicalWeek getLiturgicalWeekFor(LocalDate date);
    List<LiturgicalDay> getUpcomingFeasts(LocalDate fromDate, int count);
}
