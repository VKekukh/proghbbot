package ua.kiev.prog.proghbbot.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.logging.BotLogger;

@Component
@EnableConfigurationProperties
@ConfigurationProperties
public class BotConfiguration {
    private final String TAG = "BotConfiguration";

    @Bean
    public MessageSource messageSource() {
        BotLogger.info(TAG, "Init MessageSource");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("Windows-1251");
        messageSource.setBasename("message");
        return messageSource;
    }

    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

}
