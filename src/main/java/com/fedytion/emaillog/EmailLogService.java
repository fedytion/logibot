package com.fedytion.emaillog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class EmailLogService {

    private static final Path EMAIL_LOG_FILE = Paths.get("src", "main", "resources", "sent-emails.txt");

    private EmailLogService() {
    }

    public static boolean alreadySent(String email) {
        try {
            if (!Files.exists(EMAIL_LOG_FILE)) {
                return false;
            }

            List<String> sentEmails = Files.readAllLines(EMAIL_LOG_FILE);
            return sentEmails.contains(email);
        } catch (IOException e) {
            System.err.println("Помилка при перевірці email: " + e.getMessage());
            return false;
        }
    }

    public static void addEmail(String email) {
        try {
            // Якщо файл існує — читаємо всі email'и
            List<String> existingEmails = Files.exists(EMAIL_LOG_FILE)
                    ? Files.readAllLines(EMAIL_LOG_FILE)
                    : List.of();

            // Якщо такого email ще немає — додаємо
            if (!existingEmails.contains(email)) {
                Files.writeString(EMAIL_LOG_FILE, email + System.lineSeparator(),
                        CREATE,
                        APPEND);
                System.out.println("Email додано: " + email);
            } else {
                System.out.println("Email вже є в списку: " + email);
            }

        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлом: " + e.getMessage());
        }
    }

    public static void clearIfNeeded() {
        Path dateFile = Paths.get("src", "main", "resources", "last-cleared.txt");
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        try {
            // Читаємо дату з файлу, якщо існує
            if (Files.exists(dateFile)) {
                String content = Files.readString(dateFile).trim();
                LocalDate lastCleared = LocalDate.parse(content, formatter);

                // Якщо сьогодні вже очищено — нічого не робимо
                if (lastCleared.equals(today)) {
                    System.out.println("Файл вже очищено сьогодні.");
                    return;
                }
            }

            // Очищаємо файл і записуємо сьогоднішню дату
            Files.writeString(EMAIL_LOG_FILE, "");
            Files.writeString(dateFile, today.format(formatter));

            System.out.println("Файл очищено. Дата оновлена: " + today);

        } catch (IOException e) {
            System.err.println("Помилка при перевірці або очищенні: " + e.getMessage());
        }
    }
}
