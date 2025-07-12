package com.jc.protestantcalendar;

import java.time.LocalDate;

public class LiturgicalDay {
    private final String key;
    private final String name;
    private final LocalDate date;

    public LiturgicalDay(String key, String name, LocalDate date) {
        this.key = key;
        this.name = name;
        this.date = date;
    }

    public String getKey() { return key; }
    public String getName() { return name; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return String.format("%s: %s", name, date);
    }
}