package ru.league.greedisgood.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.league.greedisgood.bot.TelegramBot;

@RestController
public class TelegramBotController {

    private TelegramBot telegramBot;

    public TelegramBotController(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostMapping
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return telegramBot.onWebhookUpdateReceived(update);
    }
}
