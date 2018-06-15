package ua.kiev.prog.proghbbot.user;


import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.logging.BotLogger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Users {

    private static final String TAG = "Users";
    private static Map<User, String> users = new ConcurrentHashMap<>();


    public static void addUser(User user, String language) {
        BotLogger.info(TAG, "Save user to static context");
        users.put(user, language);
    }
}
