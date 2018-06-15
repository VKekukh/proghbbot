package ua.kiev.prog.proghbbot.messages;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static ua.kiev.prog.proghbbot.conf.Const.*;

@Component("startMessage")
public class StartMessage extends SendMessage implements SendingMessage {

    public SendMessage getSendingMessage(Message message, String language) {
        super.setChatId(message.getChatId());
        setBody();
        setText();
        return this;
    }

    private void setBody() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> allButtons = new ArrayList<>();

        InlineKeyboardButton enButton = new InlineKeyboardButton();
        enButton.setText(LANGUAGE_EN_NAME);
        enButton.setCallbackData(LANGUAGE_EN_LOCALE);
        row.add(enButton);

        InlineKeyboardButton uaButton = new InlineKeyboardButton();
        uaButton.setText(LANGUAGE_UA_NAME);
        uaButton.setCallbackData(LANGUAGE_UA_LOCALE);
        row.add(uaButton);

        InlineKeyboardButton ruButton = new InlineKeyboardButton();
        ruButton.setText(LANGUAGE_RU_NAME);
        ruButton.setCallbackData(LANGUAGE_RU_LOCALE);
        row.add(ruButton);

        allButtons.add(row);

        keyboardMarkup.setKeyboard(allButtons);
        this.setReplyMarkup(keyboardMarkup);

    }

    private void setText() {
        StringBuilder builder = new StringBuilder();

        builder.append(LANGUAGE_EN)
                .append(SEPARATOR)
                .append(LANGUAGE_UA)
                .append(SEPARATOR)
                .append(LANGUAGE_RU);

        this.setText(builder.toString());

    }
}
