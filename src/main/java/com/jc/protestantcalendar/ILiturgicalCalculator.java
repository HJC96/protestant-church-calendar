package com.jc.protestantcalendar;

import java.util.List;

public interface ILiturgicalCalculator {
    List<LiturgicalDay> calculate(int year);
}
