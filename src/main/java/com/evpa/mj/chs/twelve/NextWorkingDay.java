package com.evpa.mj.chs.twelve;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

        int daysToAdd = 1;

        if (dow == DayOfWeek.FRIDAY) {
            daysToAdd = 3;
        } else if (dow == DayOfWeek.SATURDAY) {
            daysToAdd = 2;
        }

        return temporal.plus(daysToAdd, ChronoUnit.DAYS);
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate date1 = date.with(new NextWorkingDay());
        System.out.println(date1);
    }
}