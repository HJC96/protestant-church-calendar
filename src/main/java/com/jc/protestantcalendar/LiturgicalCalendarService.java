package com.jc.protestantcalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

public class LiturgicalCalendarService implements ILiturgicalCalendarService {
    private final Locale locale;
    private final ResourceBundle messages;
    private final Map<Integer, List<LiturgicalDay>> calendarCache = new HashMap<>();
    private final ILiturgicalCalculator calculator;

    public LiturgicalCalendarService(Locale locale) {
        this(locale, new LiturgicalCalculator(locale));
    }

    public LiturgicalCalendarService(Locale locale, ILiturgicalCalculator calculator) {
        this.locale = locale;
        this.messages = ResourceBundle.getBundle("messages", locale);
        this.calculator = calculator;
    }

    @Override
    public LiturgicalWeek getLiturgicalWeekFor(LocalDate date) {
        LocalDate currentSunday = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LiturgicalDay seasonAnchor = findLastSeasonAnchorBefore(currentSunday);

        String seasonNameKey = "season.after.pentecost";
        if (seasonAnchor != null) {
            if ("pentecost".equals(seasonAnchor.getKey())) {
                seasonNameKey = "season.after.pentecost";
            } else if ("epiphany".equals(seasonAnchor.getKey())) {
                seasonNameKey = "season.after.epiphany";
            }
        }

        long daysBetween = ChronoUnit.DAYS.between(seasonAnchor.getDate(), currentSunday);
        int weekNumber = (int) (daysBetween / 7) + 1;

        return new LiturgicalWeek(messages.getString(seasonNameKey), weekNumber);
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

        final List<String> seasonAnchorKeys = Arrays.asList("pentecost", "epiphany", "christmas.day");

        return feasts.stream()
                .filter(day -> seasonAnchorKeys.contains(day.getKey()))
                .filter(day -> !day.getDate().isAfter(date))
                .max(Comparator.comparing(LiturgicalDay::getDate))
                .orElse(null);
    }
}
