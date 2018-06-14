package ua.kiev.prog.proghbbot.messages;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public class HelpMessage extends SendMessage {
    public HelpMessage(Message message, String language){
        super.setChatId(message.getChatId());
        super.setText("Your language is:"  + language);
    }
}
