package com.example.weatherForcasting.controller;

import com.example.weatherForcasting.model.Forecast;
import com.example.weatherForcasting.service.WeatherForcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
public class WeatherForecastController {

    @Autowired
    private WeatherForcastService weatherForcastService;

    @GetMapping(value = "/weather/{countryCode}/{zip}")
    public Forecast getWeatherForecastForZipCode(@PathVariable("countryCode") String countryCode, @PathVariable("zip") String zipCode, @QueryParam("tempOption") String tempOption){
     return weatherForcastService.getHourlyForecastForZipCode(countryCode, zipCode, tempOption!=null?tempOption:"default");
    }
}
