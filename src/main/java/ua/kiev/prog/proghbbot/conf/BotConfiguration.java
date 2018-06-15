package ua.kiev.prog.proghbbot.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties
public class BotConfiguration {

    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String botName) {
        this.name = botName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
