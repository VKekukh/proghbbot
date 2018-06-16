package ua.kiev.prog.proghbbot.handlers;

import org.telegram.telegrambots.api.interfaces.BotApiObject;
import org.telegram.telegrambots.api.methods.send.SendMessage;

public interface Handler {
    SendMessage getSendMessage(BotApiObject botApiObject);
}
