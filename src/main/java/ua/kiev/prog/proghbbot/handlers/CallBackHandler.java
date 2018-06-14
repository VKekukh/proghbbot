package ua.kiev.prog.proghbbot.handlers;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import ua.kiev.prog.proghbbot.messages.HelpMessage;

public class CallBackHandler {
    public static SendMessage getSendMessage(CallbackQuery callbackQuery) {
        Message message = callbackQuery.getMessage();

        String[] words = callbackQuery.getData().split(":");
        String command = words[0];

        SendMessage sendMessage = null;
        switch (command) {
            case "language":
                sendMessage = new HelpMessage(message, words[1]);
                break;
        }
        return sendMessage;
    }
}
