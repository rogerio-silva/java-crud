package br.com.numbersapp.examples;

import java.util.Calendar;

public class Ex_Calendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1; // Janeiro é 0
        int year = calendar.get(Calendar.YEAR);

        System.out.printf("Data atual: %02d/%02d/%d%n", day, month, year);
    }
}
