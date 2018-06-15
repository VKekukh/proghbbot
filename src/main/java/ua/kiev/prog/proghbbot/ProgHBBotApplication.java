package ua.kiev.prog.proghbbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.logging.BotLogger;

import java.util.logging.ConsoleHandler;

@SpringBootApplication
public class ProgHBBotApplication {
    public static final String TAG = "ProgHBBotApplication";

    public static void main(String[] args) {
        SpringApplication.run(ProgHBBotApplication.class, args);
        BotLogger.registerLogger(new ConsoleHandler());
    }
}
