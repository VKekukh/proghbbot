package ua.kiev.prog.proghbbot.user;

import org.telegram.telegrambots.api.objects.User;

public interface UserService {
    void saveUser(User user, String language);
}
