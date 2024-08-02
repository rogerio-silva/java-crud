package br.com.numbersapp.examples;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex_AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthdate (dd/MM/yyyy): ");
        String birthdate = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(birthdate, formatter);
        LocalDate today = LocalDate.now();

        Period age = Period.between(birthDate, today);
        System.out.println("You are " + age.getYears() + " years old.");
    }
}
