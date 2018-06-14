package ua.kiev.prog.proghbbot.handlers;


import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import ua.kiev.prog.proghbbot.messages.StartMessage;

import static ua.kiev.prog.proghbbot.conf.Const.START;

public class MessageHandler {

    public static SendMessage getSendMessage(Message message) {
        String[] words = message.getText().split(" ");
        String command = words[0].toLowerCase();
        SendMessage sendMessage = null;
        switch (command) {
            case START:
                sendMessage = new StartMessage(message);
        }

        return sendMessage;
    }


}
