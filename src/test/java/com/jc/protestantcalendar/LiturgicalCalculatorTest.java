package com.jc.protestantcalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class LiturgicalCalculatorTest {

    private ILiturgicalCalculator calculator;

    @BeforeEach
    void setUp() {
        // Using English locale for consistent testing
        ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        calculator = new LiturgicalCalculator(messages);
    }

    @Test
    @DisplayName("Should calculate major liturgical days correctly for 2025")
    void testCalculateFor2025() {
        List<LiturgicalDay> days = calculator.calculate(2025);

        assertDay(days, "easter.sunday", LocalDate.of(2025, 4, 20));
        assertDay(days, "ash.wednesday", LocalDate.of(2025, 3, 5));
        assertDay(days, "pentecost", LocalDate.of(2025, 6, 8));
        assertDay(days, "first.sunday.of.advent", LocalDate.of(2025, 11, 30));
    }

    private void assertDay(List<LiturgicalDay> days, String key, LocalDate expectedDate) {
        Optional<LiturgicalDay> foundDay = days.stream()
                .filter(day -> day.getKey().equals(key))
                .findFirst();

        assertTrue(foundDay.isPresent(), "Day with key '" + key + "' should exist.");
        assertEquals(expectedDate, foundDay.get().getDate(), "Date for '" + key + "' should match.");
    }
}
