/**
 * 
 */
package com.kpcard.telegrambots.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;

import com.kpcard.telegrambots.ApplicationConfig;
import com.kpcard.telegrambots.commands.HelloCommand;
import com.kpcard.telegrambots.commands.HelpCommand;
import com.kpcard.telegrambots.commands.ShoutCommand;
import com.kpcard.telegrambots.commands.SwitchCommand;
import com.kpcard.telegrambots.commands.WhoCommand;

/**
 * @author happymoney
 *
 */
@Component
public class CommandsHandler extends TelegramLongPollingCommandBot {

	private static final Logger logger = LoggerFactory.getLogger(CommandsHandler.class);

	@Autowired ApplicationConfig appConfig;	
	
	public CommandsHandler() {
		// TODO Auto-generated constructor stub
        register(new HelloCommand());
        register(new WhoCommand());
        register(new ShoutCommand());
        register(new SwitchCommand());
        
        HelpCommand helpCommand = new HelpCommand(this);
        register(helpCommand);
	}

	@Override
	public void processNonCommandUpdate(Update update) {
		// TODO Auto-generated method stub
		
       if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                SendMessage echoMessage = new SendMessage();
                echoMessage.setChatId(message.getChatId().toString());
                echoMessage.setText("Hey heres your message:\n" + message.getText());

                try {
                    sendMessage(echoMessage);
                } catch (TelegramApiException e) {
                	logger.error(e.toString());
                }
            }
        }
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		//return "269437500:AAEwAYpqj5H97RdJXbRfVJutzxNvNxwyGMo";
//		
		String token = "";
		
		if ( appConfig != null ) {
			logger.debug("command bot token : {}", appConfig.getCommandBotsToken());
			token = appConfig.getCommandBotsToken();
		}
		
		return token;
	}

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		//return "kpc_test_command_bot";
//		
		String username = "";
		
		if ( appConfig != null ) {
			logger.debug("command bot username : {}", appConfig.getCommandBotsUsername());
			username = appConfig.getCommandBotsUsername();
		}
		
		return username;
	}

}
