package com.pm.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends  GlobalAuthenticationConfigurerAdapter{

	PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("mahi").password(encoder.encode("12345")).roles("ADMIN","USER").authorities("CAN_READ","CAN_WRITE","CAN_DELETE")
		.and()
		.withUser("roman").password(encoder.encode("12345")).roles("USER").authorities("CAN_READ");
	}

	
}
