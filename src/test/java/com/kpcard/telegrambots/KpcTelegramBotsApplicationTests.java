package com.kpcard.telegrambots;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

import com.kpcard.telegrambots.handler.CommandsHandler;
import com.kpcard.telegrambots.handler.MessageHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KpcTelegramBotsApplicationTests {

	private static final Logger logger = LoggerFactory
			.getLogger(KpcTelegramBotsApplicationTests.class);

	@Test
	public void contextLoads() {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		
        try {
        	telegramBotsApi.registerBot(new MessageHandler());
        	telegramBotsApi.registerBot(new CommandsHandler());
        } catch (TelegramApiException e) {
        	logger.error(e.getMessage());
        }
	}

}
