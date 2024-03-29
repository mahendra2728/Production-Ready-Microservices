package com.pm.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@EntityScan(value = "com.pm.rentapp.commons.model")
public class OAuth2JdbcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2JdbcExampleApplication.class, args);
	}

}
