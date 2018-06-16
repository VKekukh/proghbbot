package ua.kiev.prog.proghbbot.util;

import org.springframework.stereotype.Service;

import java.util.Locale;

import static ua.kiev.prog.proghbbot.conf.Const.LANGUAGE_RU_LOCALE;
import static ua.kiev.prog.proghbbot.conf.Const.LANGUAGE_UA_LOCALE;

@Service
public class LocaleService {

    public Locale getLocale(String language) {
        Locale locale;
        switch (language) {
            case LANGUAGE_RU_LOCALE:
                locale = new Locale("ru", "RU");
                break;
            case LANGUAGE_UA_LOCALE:
                locale = new Locale("uk", "UA");
                break;
            default:
                locale = Locale.ENGLISH;
        }
        return locale;
    }
}

