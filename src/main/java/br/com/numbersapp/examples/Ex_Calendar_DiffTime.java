package br.com.numbersapp.examples;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Ex_Calendar_DiffTime {
    public static void main(String[] args) {
        // Definir data de início
        Calendar startDate = Calendar.getInstance();
        startDate.set(2024, Calendar.JANUARY, 1, 8, 30, 0); // 1 de janeiro de 2024, 08:30:00

        // Definir data de fim
        Calendar endDate = Calendar.getInstance();
        endDate.set(2024, Calendar.JANUARY, 2, 10, 45, 30); // 2 de janeiro de 2024, 10:45:30

        // Calcular a diferença em milissegundos
        long startTime = startDate.getTimeInMillis();
        long endTime = endDate.getTimeInMillis();
        long diffTime = endTime - startTime;

        // Converter milissegundos para horas, minutos e segundos
        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(diffTime);
        long hours = diffInSeconds / 3600;
        long minutes = (diffInSeconds % 3600) / 60;
        long seconds = diffInSeconds % 60;

        // Exibir a diferença em horas, minutos e segundos
        System.out.printf("Diferença: %d horas, %d minutos, %d segundos%n", hours, minutes, seconds);
    }
}
