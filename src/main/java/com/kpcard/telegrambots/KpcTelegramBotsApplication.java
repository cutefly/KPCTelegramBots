package com.kpcard.telegrambots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
//@EnableJpaRepositories
public class KpcTelegramBotsApplication {

	private static final Logger logger = LoggerFactory
			.getLogger(KpcTelegramBotsApplication.class);

	public static void main(String[] args) {
		logger.info("String .....");
		SpringApplication.run(KpcTelegramBotsApplication.class, args);
	}
}
