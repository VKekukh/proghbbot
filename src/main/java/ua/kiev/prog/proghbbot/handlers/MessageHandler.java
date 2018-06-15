package ua.kiev.prog.proghbbot.handlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.interfaces.BotApiObject;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import ua.kiev.prog.proghbbot.messages.MessageService;

import static ua.kiev.prog.proghbbot.conf.Const.START;

@Component("messageHandler")
public class MessageHandler implements Handler {

    @Autowired
    MessageService messageService;

    public SendMessage getSendMessage(BotApiObject botApiObject) {
        Message message = (Message) botApiObject;

        String[] words = message.getText().split(" ");
        String command = words[0].toLowerCase();
        SendMessage sendMessage = null;
        switch (command) {
            case START:
                sendMessage = messageService.getStartMessage(message);
                break;
        }

        return sendMessage;
    }
}
