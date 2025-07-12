package com.jc.protestantcalendar;

import java.time.LocalDate;
import java.util.*;

public class LiturgicalCalculator implements ILiturgicalCalculator {
    private final ResourceBundle messages;

    public LiturgicalCalculator(Locale locale) {
        this.messages = ResourceBundle.getBundle("messages", locale);
    }

    @Override
    public List<LiturgicalDay> calculate(int year) {
        List<LiturgicalDay> events = new ArrayList<>();
        LocalDate easterDate = calculateEaster(year);

        addDay(events, "easter.sunday", easterDate);
        addDay(events, "ash.wednesday", easterDate.minusDays(46));
        addDay(events, "palm.sunday", easterDate.minusDays(7));
        addDay(events, "good.friday", easterDate.minusDays(2));
        addDay(events, "pentecost", easterDate.plusDays(49));
        addDay(events, "trinity.sunday", easterDate.plusDays(56));
        addDay(events, "epiphany", LocalDate.of(year, 1, 6));
        addDay(events, "christmas.day", LocalDate.of(year, 12, 25));

        LocalDate adventStart = LocalDate.of(year, 12, 25)
                .minusDays(LocalDate.of(year, 12, 25).getDayOfWeek().getValue() % 7)
                .minusWeeks(3);
        addDay(events, "first.sunday.of.advent", adventStart);
        addDay(events, "christ.the.king", adventStart.minusWeeks(1));

        events.sort(Comparator.comparing(LiturgicalDay::getDate));
        return events;
    }

    private void addDay(List<LiturgicalDay> events, String key, LocalDate date) {
        events.add(new LiturgicalDay(key, messages.getString(key), date));
    }

    private LocalDate calculateEaster(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(year, month, day);
    }
}
