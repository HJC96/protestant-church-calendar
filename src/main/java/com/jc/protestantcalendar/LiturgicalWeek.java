package com.jc.protestantcalendar;

public class LiturgicalWeek {
    private final String seasonName;
    private final int weekNumber;

    public LiturgicalWeek(String seasonName, int weekNumber) {
        this.seasonName = seasonName;
        this.weekNumber = weekNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s", seasonName, toOrdinal(weekNumber) + " week");
    }

    private String toOrdinal(int number) {
        if (number >= 11 && number <= 13) return number + "th";
        switch (number % 10) {
            case 1: return number + "st";
            case 2: return number + "nd";
            case 3: return number + "rd";
            default: return number + "th";
        }
    }
}