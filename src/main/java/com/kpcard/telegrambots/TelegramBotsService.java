package com.kpcard.telegrambots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

import com.kpcard.telegrambots.handler.CommandsHandler;
import com.kpcard.telegrambots.handler.MessageHandler;

@Service
public class TelegramBotsService implements InitializingBean {

	private static final Logger logger = LoggerFactory
			.getLogger(TelegramBotsService.class);
	
	@Autowired MessageHandler messageHandler;
	@Autowired CommandsHandler commandsHandler;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		
		try {
        	telegramBotsApi.registerBot(messageHandler);
        	telegramBotsApi.registerBot(commandsHandler);
        } catch (TelegramApiException e) {
        	logger.error(e.toString());

        }
		
	}
	
	
	
	
}
