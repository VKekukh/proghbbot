package ua.kiev.prog.proghbbot.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import ua.kiev.prog.proghbbot.user.UserService;
import ua.kiev.prog.proghbbot.util.LocaleService;


@Component("helpMessage")
public class HelpMessage extends SendMessage implements SendingMessage {

    @Autowired
    MessageSource messageSource;

    @Autowired
    LocaleService localeService;

    @Autowired
    UserService userService;

    @Override
    public SendMessage getSendingMessage(Message message, String language) {

        super.setChatId(message.getChatId());
        String userName = userService.getUserByChatId(message.getChatId()).getFirstName();

        StringBuilder builder = new StringBuilder();

        builder.append(userName)
                .append("! ")
                .append(messageSource.getMessage("welcome", null, localeService.getLocale(language)));

        super.setText(builder.toString());
        return this;
    }
}
