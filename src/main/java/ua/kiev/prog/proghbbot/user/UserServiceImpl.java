package ua.kiev.prog.proghbbot.user;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.User;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(long chatId, User user, String language) {
        Users.addUser(chatId, user, language);
        //save to file
    }

    @Override
    public ChatUser getUserByChatId(long chatId) {
        return Users.getUsers().get(chatId);
    }

    @Override
    public String getLanguageByChatId(long chatId) {

        return Users.getUsers().get(chatId).getLanguageCode();
    }
}
