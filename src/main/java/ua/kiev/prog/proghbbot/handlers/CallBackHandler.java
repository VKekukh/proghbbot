package ua.kiev.prog.proghbbot.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.interfaces.BotApiObject;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import ua.kiev.prog.proghbbot.messages.MessageService;

@Component("callBackHandler")
public class CallBackHandler implements Handler {

    @Autowired
    MessageService messageService;


    public SendMessage getSendMessage(BotApiObject botApiObject) {
        CallbackQuery callbackQuery = (CallbackQuery) botApiObject;

        Message message = callbackQuery.getMessage();

        String[] words = callbackQuery.getData().split(":");
        String command = words[0];

        SendMessage sendMessage = null;
        switch (command) {
            case "language":
                sendMessage = messageService.getHelpMessage(message, words[1]);
                break;
        }
        return sendMessage;
    }
}
