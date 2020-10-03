package com.pm.authorization.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.pm.authorization.AccessToken;
import com.pm.rentapp.commons.model.Customer;

@Controller
public class LoginController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/secure")
	public String secure() {
		return "secure";
	}

	@GetMapping("/customers")
	public String securePage(Model model) {

		// Setting Header
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add("Authorization", AccessToken.getAccessToken());

		// Setting Entity
		HttpEntity<Customer[]> customerEntity = new HttpEntity<>(httpHeader);

		// Calling sevice through RestTemplate
		try {
			ResponseEntity<Customer[]> response = restTemplate.exchange("http://localhost:8081/customers/customer",
					HttpMethod.GET, customerEntity, Customer[].class);
			model.addAttribute("customers", response.getBody());
		} catch (HttpStatusCodeException e) {

			ResponseEntity errorResponse = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
					.body(e.getResponseBodyAsString());
			model.addAttribute("error", errorResponse);
		}
		return "secure";
	}

	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		model.addAttribute("logout", "Username Logout successfully...");
		return "logout";
	}
}
