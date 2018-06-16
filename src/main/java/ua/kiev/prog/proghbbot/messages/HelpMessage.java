package ua.kiev.prog.proghbbot.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import ua.kiev.prog.proghbbot.user.UserService;
import ua.kiev.prog.proghbbot.util.LocaleService;

import java.util.Locale;


@Component("helpMessage")
public class HelpMessage extends SendMessage implements SendingMessage {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    LocaleService localeService;

    @Override
    public SendMessage getSendingMessage(Message message, String language) {
        userService.saveUser(message.getFrom(), language);
        super.setChatId(message.getChatId());
        super.setText(messageSource.getMessage("welcome", null, localeService.getLocale(language)));
        return this;
    }
}
