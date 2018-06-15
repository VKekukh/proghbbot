package ua.kiev.prog.proghbbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.logging.BotLogger;
import ua.kiev.prog.proghbbot.conf.BotConfiguration;
import ua.kiev.prog.proghbbot.conf.Const;
import ua.kiev.prog.proghbbot.handlers.CallBackHandler;
import ua.kiev.prog.proghbbot.handlers.MessageHandler;

import javax.annotation.PostConstruct;

@Component
public class ProgHBBot extends TelegramLongPollingBot {

    private static final String TEG = "ProgHBBot";

    @Autowired
    MessageHandler messageHandler;

    @Autowired
    CallBackHandler callBackHandler;

    @Autowired
    BotConfiguration config;

    static {
        BotLogger.info(TEG, "static init");
        ApiContextInitializer.init();
    }

    @PostConstruct
    public void registerBot() {
        TelegramBotsApi api = new TelegramBotsApi();
        try {
            api.registerBot(this);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = null;
        if (update.hasCallbackQuery() && update.getCallbackQuery().getData() != null) {
            BotLogger.info(TEG, "Message has callback query:" + update.getCallbackQuery().getData());
            sendMessage = callBackHandler.getSendMessage(update.getCallbackQuery());
        } else {
            BotLogger.info(TEG, "Processing simple Message :" + update.getMessage().getText());
            sendMessage = messageHandler.getSendMessage(update.getMessage());
        }

        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }
}
