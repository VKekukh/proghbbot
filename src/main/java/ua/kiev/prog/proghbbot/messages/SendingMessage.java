package ua.kiev.prog.proghbbot.messages;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public interface SendingMessage {
    SendMessage getSendingMessage(Message message, String language);
}
