package com.bankonus.temperatureconverter.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bankonus.temperatureconverter.service.TemperatureConverterService;
import com.bankonus.temperatureconverter.service.TemperatureConverterResponse;

@Controller
@EnableAsync
public class TemperatureConverterController {

    @Autowired
    TemperatureConverterService tempconvService;

    @RequestMapping(value = "/convert")
    public ModelAndView convert(@RequestParam String temp, @RequestParam float fTemp) {
        ModelAndView mv = new ModelAndView();;
        try {
            System.out.println("temp--->" + temp + "---fTemp--->" + fTemp);
            CompletableFuture<TemperatureConverterResponse> resp = tempconvService.getTemp(temp, fTemp);
            System.out.println("Farjenheit-->" + resp.get().getFahrenheit());
            System.out.println("Celcius--->" + resp.get().getCelsius());

            mv.setViewName("display");

            mv.addObject("Celcius", resp.get().getCelsius());

            mv.addObject("Farenheit", resp.get().getFahrenheit());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mv;
    }

}
