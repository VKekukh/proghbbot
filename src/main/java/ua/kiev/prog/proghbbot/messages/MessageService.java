package ua.kiev.prog.proghbbot.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;


@Service
public class MessageService {

    @Autowired
    @Qualifier("startMessage")
    SendingMessage startMessage;

    @Autowired
    @Qualifier("helpMessage")
    SendingMessage helpMessage;


    public SendMessage getStartMessage(Message message) {
        return startMessage.getSendingMessage(message, null);
    }

    public SendMessage getHelpMessage(Message message, String language) {
        return helpMessage.getSendingMessage(message, language);
    }
}
