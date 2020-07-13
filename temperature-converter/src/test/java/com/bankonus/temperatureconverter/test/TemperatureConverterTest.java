package com.bankonus.temperatureconverter.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.bankonus.temperatureconverter.service.TemperatureConverterResponse;
import com.bankonus.temperatureconverter.service.TemperatureConverterService;

@RunWith(JUnit4.class)
public class TemperatureConverterTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	TemperatureConverterService tempconvService;

	@Test
	public void convertCelsiusToFahrenheitTest() throws InterruptedException, ExecutionException {
		CompletableFuture<TemperatureConverterResponse> resp = tempconvService.getTemp("Celsius", "40");
		Assert.assertEquals(104.0, resp.get().getFahrenheit(), 0.0001d);
	}

	@Test
	public void convertFahrenheitToCelsiusTest() throws InterruptedException, ExecutionException {
		CompletableFuture<TemperatureConverterResponse> resp = tempconvService.getTemp("Fahrenheit", "140");
		Assert.assertEquals(60.0, resp.get().getCelsius(), 0.0001d);
	}
}
