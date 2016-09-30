package com.kpcard.telegrambots.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import com.kpcard.telegrambots.ApplicationConfig;

@Component
public class MessageHandler extends TelegramLongPollingBot {

	private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);
	
	@Autowired ApplicationConfig appConfig;
	
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		Integer		id;
		String		text;
		String		message;
		
		logger.debug(update.toString());
		message = String.format("Message from id = %d, firstName = %s, lastName = %s", 
				update.getMessage().getFrom().getId(),
				update.getMessage().getFrom().getFirstName(),
				update.getMessage().getFrom().getLastName());
		logger.info(message);
		logger.debug(String.format("text = %s", update.getMessage().getText()));
		id = update.getMessage().getFrom().getId();
		text = update.getMessage().getText();
		
		SendMessage	sendMessage = new SendMessage();
//		sendMessage.setChatId("@KPCChannel");
		sendMessage.setChatId(id.toString());
		if ( "/who".equals(text) == true )
			sendMessage.setText(String.format("Your id is %s", id));
		else
			sendMessage.setText(text);
				
		try {
			Message recvNessage = sendMessage(sendMessage);
			logger.debug(recvNessage.toString());
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
		}

	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		//return "260464236:AAHNWWCkMqkYott-ebTSqAF-VsWtjid8RAw";
		String token;
		
		if ( appConfig != null ) {
			logger.debug("message bot username : {}", appConfig.getMessageBotsToken());
			token = appConfig.getMessageBotsToken();
		} else {
			token = "260464236:AAHNWWCkMqkYott-ebTSqAF-VsWtjid8RAw";
		}
		
		return token;
	}

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		//return "kpc_test_message_bot";
		String username;
		
		if ( appConfig != null ) {
			logger.info("message bot username : {}", appConfig.getMessageBotsUsername());
			username = appConfig.getMessageBotsUsername();
		} else {
			username = "kpc_test_message_bot";
		}
		
		return username;
	}

}
