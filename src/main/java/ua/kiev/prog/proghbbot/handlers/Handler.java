package ua.kiev.prog.proghbbot.handlers;

import org.telegram.telegrambots.api.interfaces.BotApiObject;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public interface Handler {
    SendMessage getSendMessage(BotApiObject botApiObject);
}
