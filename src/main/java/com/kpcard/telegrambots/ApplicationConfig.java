package com.kpcard.telegrambots;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {

	@Value("${bot.token.message}")
	private String messageBotsToken;

	@Value("${bot.username.message}")
	private String messageBotsUsername;

	@Value("${bot.token.command}")
	private String commandBotsToken;

	@Value("${bot.username.command}")
	private String commandBotsUsername;

	public ApplicationConfig() {
	// TODO Auto-generated constructor stub
        System.out.println("================== " + messageBotsToken + "================== ");
	}
	
	@PostConstruct
    public void init() {
        System.out.println("================== " + messageBotsToken + "================== ");
    }
	/**
	 * @return the messageBotsToken
	 */
	public String getMessageBotsToken() {
		return messageBotsToken;
	}

	/**
	 * @param messageBotsToken the messageBotsToken to set
	 */
	public void setMessageBotsToken(String messageBotsToken) {
		this.messageBotsToken = messageBotsToken;
	}

	/**
	 * @return the messageBotsUsername
	 */
	public String getMessageBotsUsername() {
		return messageBotsUsername;
	}

	/**
	 * @param messageBotsUsername the messageBotsUsername to set
	 */
	public void setMessageBotsUsername(String messageBotsUsername) {
		this.messageBotsUsername = messageBotsUsername;
	}

	/**
	 * @return the commandBotsToken
	 */
	public String getCommandBotsToken() {
		return commandBotsToken;
	}

	/**
	 * @param commandBotsToken the commandBotsToken to set
	 */
	public void setCommandBotsToken(String commandBotsToken) {
		this.commandBotsToken = commandBotsToken;
	}

	/**
	 * @return the commandBotsUsername
	 */
	public String getCommandBotsUsername() {
		return commandBotsUsername;
	}

	/**
	 * @param commandBotsUsername the commandBotsUsername to set
	 */
	public void setCommandBotsUsername(String commandBotsUsername) {
		this.commandBotsUsername = commandBotsUsername;
	}

	
}
