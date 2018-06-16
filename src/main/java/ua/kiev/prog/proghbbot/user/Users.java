package ua.kiev.prog.proghbbot.user;


import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.logging.BotLogger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Users {

    private static final String TAG = "Users";
    private static Map<Long, ChatUser> users = new ConcurrentHashMap<>();


    public static void addUser(long chatId, User user, String language) {
        BotLogger.info(TAG, "Save user to static context");
        ChatUser chatUser = new ChatUser();
        chatUser.setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setUserName(user.getUserName())
                .setLanguageCode(language);

        users.put(chatId, chatUser);
    }

    public static Map<Long, ChatUser> getUsers() {
        return users;
    }
}
