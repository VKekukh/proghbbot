package ua.kiev.prog.proghbbot.user;

import org.telegram.telegrambots.api.objects.User;

public interface UserService {
    void saveUser(long chatId, User user, String language);

    ChatUser getUserByChatId(long chatId);

    String getLanguageByChatId(long chatId);
}
