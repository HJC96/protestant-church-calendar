package com.jc.protestantcalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

public class LiturgicalCalendarService implements ILiturgicalCalendarService {
    private final ResourceBundle messages;
    private final Map<Integer, List<LiturgicalDay>> calendarCache = new HashMap<>();
    private final LiturgicalCalculator calculator;

    public LiturgicalCalendarService(LiturgicalCalculator calculator) {
        this.messages = calculator.getMessages();
        this.calculator = calculator;
    }

    @Override
    public LiturgicalWeek getLiturgicalWeekFor(LocalDate date) {
        LocalDate currentSunday = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LiturgicalDay seasonAnchor = findLastSeasonAnchorBefore(currentSunday);

        long daysBetween = ChronoUnit.DAYS.between(seasonAnchor.getDate(), currentSunday);
        int weekNumber = (int) (daysBetween / 7);

        String seasonAnchorString = seasonAnchor.toString();
        String seasonNameKey = seasonAnchorString.substring(0, seasonAnchorString.indexOf(':'));

        return new LiturgicalWeek(seasonNameKey, weekNumber, messages);
    }

    @Override
    public List<LiturgicalDay> getUpcomingFeasts(LocalDate fromDate, int count) {
        List<LiturgicalDay> allFeasts = new ArrayList<>(getYearlyCalendar(fromDate.getYear()));
        if (fromDate.getMonthValue() > 10) {
            allFeasts.addAll(getYearlyCalendar(fromDate.getYear() + 1));
        }

        return allFeasts.stream()
                .filter(day -> !day.getDate().isBefore(fromDate))
                .limit(count)
                .collect(Collectors.toList());
    }

    private List<LiturgicalDay> getYearlyCalendar(int year) {
        return calendarCache.computeIfAbsent(year, y -> calculator.calculate(y));
    }

    private LiturgicalDay findLastSeasonAnchorBefore(LocalDate date) {
        List<LiturgicalDay> feasts = new ArrayList<>(getYearlyCalendar(date.getYear()));
        feasts.addAll(getYearlyCalendar(date.getYear() - 1));

        return feasts.stream()
                .filter(day -> !day.getDate().isAfter(date))
                .max(Comparator.comparing(LiturgicalDay::getDate))
                .orElse(null);
    }
}
