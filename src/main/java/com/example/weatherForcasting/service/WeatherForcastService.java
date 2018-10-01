package com.example.weatherForcasting.service;

import com.example.weatherForcasting.model.Forecast;
import org.springframework.stereotype.Service;


@Service
public interface WeatherForcastService {

    Forecast getHourlyForecastForZipCode(String countryCode, String zipCode, String tempOption);

}
