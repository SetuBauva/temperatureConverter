package com.bankonus.temperatureconverter.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bankonus.temperatureconverter.service.TemperatureConverterResponse;
import com.bankonus.temperatureconverter.service.TemperatureConverterService;

/**
 * 
 * @author setubauva
 *
 *         Controller class to convert Temperature
 */

@Controller
@EnableAsync
public class TemperatureConverterController {

	@Autowired
	TemperatureConverterService tempconvService;

	@RequestMapping(value = "/convert")
	public ModelAndView convertTemperature(@RequestParam String temperature, @RequestParam String fahrenheitTemp,
			@RequestParam String celsiusTemp) {

		ModelAndView modelAndView = new ModelAndView();
		CompletableFuture<TemperatureConverterResponse> resp;
		try {
			if (!fahrenheitTemp.isBlank())
				resp = tempconvService.getTemp(temperature, fahrenheitTemp);
			else
				resp = tempconvService.getTemp(temperature, celsiusTemp);

			modelAndView.setViewName("tempCon");
			modelAndView.addObject("Celcius", resp.get().getCelsius());
			modelAndView.addObject("Farenheit", resp.get().getFahrenheit());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

}
