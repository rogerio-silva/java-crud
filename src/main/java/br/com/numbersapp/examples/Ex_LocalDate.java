package br.com.numbersapp.examples;

import java.time.LocalDate;

public class Ex_LocalDate {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today's date: " + today);

        LocalDate birthday = LocalDate.of(1990, 7, 29);
        System.out.println("Birthday: " + birthday);
    }
}
