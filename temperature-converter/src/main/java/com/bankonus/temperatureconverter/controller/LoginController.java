package com.bankonus.temperatureconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author setubauva
 *
 *         Controller to navigate to various jsp pages
 */

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login")
	public String loginPage() {

		return "login";
	}

	@RequestMapping(value = "/logout-success")
	public String logoutPage() {

		return "login";
	}

	@RequestMapping("/tempCon")
	public String temperatureConverterPage() {
		return "tempCon";
	}
}