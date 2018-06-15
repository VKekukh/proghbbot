package ua.kiev.prog.proghbbot.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import ua.kiev.prog.proghbbot.user.UserService;


@Component("helpMessage")
public class HelpMessage extends SendMessage implements SendingMessage {

    @Autowired
    UserService service;

    @Override
    public SendMessage getSendingMessage(Message message, String language) {
        service.saveUser(message.getFrom(), language);
        super.setChatId(message.getChatId());
        super.setText("Your language is:" + language);
        return this;
    }
}
