package br.com.numbersapp.examples;

import java.util.Calendar;

public class Ex_Calendar_DiffDate {
    public static void main(String[] args) {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2024, Calendar.JANUARY, 1,10,45,45);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2024, Calendar.DECEMBER, 31,17,30,30);

        long startTime = startDate.getTimeInMillis();
        long endTime = endDate.getTimeInMillis();

        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);

        System.out.println("Diferença em dias: " + diffDays);
        System.out.println("Diferença em meses: " + diffDays / 30);
        System.out.println("Diferença em anos: " + diffDays / 365);
    }
}
