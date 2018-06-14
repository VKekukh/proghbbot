package ua.kiev.prog.proghbbot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;
import ua.kiev.prog.proghbbot.conf.Const;
import ua.kiev.prog.proghbbot.handlers.CallBackHandler;
import ua.kiev.prog.proghbbot.handlers.MessageHandler;

import javax.security.auth.callback.CallbackHandler;

public class ProgHBBot extends TelegramLongPollingBot {

    private static final String TEG = "ProgHBBot";


    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = null;
        if (update.hasCallbackQuery() && update.getCallbackQuery().getData() != null) {
            BotLogger.info(TEG, "Message has callback query:" + update.getCallbackQuery().getData());
            sendMessage = CallBackHandler.getSendMessage(update.getCallbackQuery());
        } else {
            BotLogger.info(TEG, "Processing simple Message :" + update.getMessage().getText());
            sendMessage = MessageHandler.getSendMessage(update.getMessage());
        }

        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return Const.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return Const.BOT_TOKEN;
    }
}
