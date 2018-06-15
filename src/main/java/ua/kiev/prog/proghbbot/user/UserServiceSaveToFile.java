package ua.kiev.prog.proghbbot.user;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.User;

@Service
public class UserServiceSaveToFile implements UserService {

    @Override
    public void saveUser(User user, String language) {
        Users.addUser(user, language);
        //save to file
    }
}
