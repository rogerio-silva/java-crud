package br.com.numbersapp.examples;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Ex_TimeLivedCalculator {
    public static void main(String[] args) {
        // Data de nascimento (substitua pelos valores desejados)
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(1990, Calendar.JULY, 29, 14, 30, 0); // 29 de julho de 1990, 14:30:00

        // Data atual
        Calendar currentDate = Calendar.getInstance();

        // Calcular a diferença em milissegundos
        long startTime = birthDate.getTimeInMillis();
        long endTime = currentDate.getTimeInMillis();
        long diffTime = endTime - startTime;

        // Calcular anos, meses, dias
        int years = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        int months = currentDate.get(Calendar.MONTH) - birthDate.get(Calendar.MONTH);
        int days = currentDate.get(Calendar.DAY_OF_MONTH) - birthDate.get(Calendar.DAY_OF_MONTH);

        // Ajustar anos e meses se necessário
        if (months < 0) {
            years--;
            months += 12;
        }

        if (days < 0) {
            months--;
            Calendar temp = (Calendar) birthDate.clone();
            temp.add(Calendar.MONTH, months + 1);
            days += temp.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        // Converter milissegundos restantes para horas, minutos e segundos
        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(diffTime);
        long hours = diffInSeconds / 3600;
        long minutes = (diffInSeconds % 3600) / 60;
        long seconds = diffInSeconds % 60;

        // Exibir o tempo vivido
        System.out.printf("Você viveu: %d anos, %d meses, %d dias, %d horas, %d minutos, %d segundos%n",
                years, months, days, hours % 24, minutes % 60, seconds);
    }
}
