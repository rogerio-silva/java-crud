package br.com.numbersapp.examples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex_Date_FormatoBR {
    public static void main(String[] args) {
        // Criação do objeto LocalDate para a data atual
        LocalDate today = LocalDate.now();

        // Definição do padrão de formatação brasileiro
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatação da data atual
        String formattedToday = today.format(formatter);
        System.out.println("Data de hoje: " + formattedToday);

        // Criação do objeto LocalDate para uma data específica (exemplo de aniversário)
        LocalDate birthday = LocalDate.of(1990, 7, 29);

        // Formatação da data de aniversário
        String formattedBirthday = birthday.format(formatter);
        System.out.println("Data de aniversário: " + formattedBirthday);
    }
}
