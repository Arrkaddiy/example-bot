package ru.league.greedisgood.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendContact;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramWebhookBot {

    @Value("bot.userName")
    private String botUserName;
    @Value("bot.token")
    private String botToken;
    @Value("bot.path")
    private String botPath;

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        SendContact contact = new SendContact();
        if (update.hasMessage()) {
            String chatId = String.valueOf(update.getMessage().getChatId());
            contact.setChatId(chatId);
            contact.setFirstName("Аркадий");
            contact.setPhoneNumber("89091647710");
        }

        return contact;
    }
}
