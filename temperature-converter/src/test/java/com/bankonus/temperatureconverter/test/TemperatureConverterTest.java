package com.bankonus.temperatureconverter.test;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bankonus.temperatureconverter.service.TemperatureConverterService;



@ExtendWith(MockitoExtension.class)
@RunWith(JUnit4.class)
@ExtendWith(SpringExtension.class)
public class TemperatureConverterTest {
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	TemperatureConverterService tempconvService;

	//@Mock
	//private PhoneNumberDao repo;

	@SuppressWarnings("deprecation")
	@Test
	public void getAllPhoneNumbers() throws Exception {
		tempconvService.getTemp("Celsius","40");
		tempconvService.getTemp("Fahrenheit","100");
		
		tempconvService.getTemp("Celsius","45");
		tempconvService.getTemp("Fahrenheit","140");
	}

}
