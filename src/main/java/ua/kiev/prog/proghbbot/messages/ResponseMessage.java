package ua.kiev.prog.proghbbot.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import ua.kiev.prog.proghbbot.util.LocaleService;

@Component("responseMessage")
public class ResponseMessage extends SendMessage implements SendingMessage {

    @Autowired
    MessageSource messageSource;

    @Autowired
    LocaleService localeService;

    @Override
    public SendMessage getSendingMessage(Message message, String language) {

        super.setChatId(message.getChatId());
        super.setText(getResponse(message.getText(), language));
        return this;
    }

    private String getResponse(String text, String language) {
        String apiResponse = messageSource.getMessage("notImpl", null, localeService.getLocale(language));
        String template = messageSource.getMessage("testResponse", null, localeService.getLocale(language));
        return String.format(template, text, apiResponse);
    }
}
