package br.com.numbersapp.examples;

import java.time.LocalDate;
import java.time.Period;

public class Ex_DateManipulation {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println("Next week: " + nextWeek);

        Period period = Period.between(today, nextWeek);
        System.out.println("Period: " + period.getDays() + " days");
    }
}
