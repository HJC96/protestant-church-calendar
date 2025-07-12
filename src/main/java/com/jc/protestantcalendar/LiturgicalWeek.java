package com.jc.protestantcalendar;

import java.util.Locale;
import java.util.ResourceBundle;

public class LiturgicalWeek {
    private final String seasonName;
    private final int weekNumber;
    private final ResourceBundle messages;

    public LiturgicalWeek(String seasonName, int weekNumber, ResourceBundle messages) {
        this.seasonName = seasonName;
        this.weekNumber = weekNumber;
        this.messages = messages;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    @Override
    public String toString() {
        String weekLabel = messages.getString("week.label");
        return String.format("%s %s %s", seasonName, toOrdinal(weekNumber), weekLabel);
    }

    private String toOrdinal(int number) {
        switch (number % 10) {
            case 1: return message("ordinal.suffix.1");
            case 2: return message("ordinal.suffix.2");
            case 3: return message("ordinal.suffix.3");
            case 4: return message("ordinal.suffix.4");
            case 5: return message("ordinal.suffix.5");
            case 6: return message("ordinal.suffix.6");
            case 7: return message("ordinal.suffix.7");
            case 8: return message("ordinal.suffix.8");
            case 9: return message("ordinal.suffix.9");
            case 10: return message("ordinal.suffix.10");
            case 11: return message("ordinal.suffix.11");
            case 12: return message("ordinal.suffix.12");
            case 13: return message("ordinal.suffix.13");
            case 14: return message("ordinal.suffix.14");
            case 15: return message("ordinal.suffix.15");
            case 16: return message("ordinal.suffix.16");
            case 17: return message("ordinal.suffix.17");
            case 18: return message("ordinal.suffix.18");
            case 19: return message("ordinal.suffix.19");
            case 20: return message("ordinal.suffix.20");
            default: return message("ordinal.suffix.1");
        }
    }

    private String message(String key) {
        if(messages.getLocale().equals(Locale.ENGLISH)){
            return messages.getString(key)+ messages.getString("week.suffix"); }
        else{
            return messages.getString("week.suffix") + messages.getString(key);
        }
    }
}
