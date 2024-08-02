package br.com.numbersapp.examples;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex_DateFormatting {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
    }
}
