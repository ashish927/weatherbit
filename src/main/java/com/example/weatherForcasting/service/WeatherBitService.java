package com.example.weatherForcasting.service;

import com.example.weatherForcasting.helper.WeatherBitHelper;
import com.example.weatherForcasting.model.Duration;
import com.example.weatherForcasting.model.Forecast;
import com.example.weatherForcasting.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherBitService implements WeatherForcastService {

    @Autowired
    private WeatherBitHelper weatherBitHelper;



    @Override
    public Forecast getHourlyForecastForZipCode(String countryCode, String zipCode, String tempOption) {
        Forecast forecast = weatherBitHelper.getHourlyForecast(countryCode,zipCode, Duration.Daily);
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(forecast.getTimezone()));
        List<Weather> weatherList = forecast.getWeatherList().stream().filter(weather -> weather.getLocalDateTime().toLocalDate().isAfter(localDateTime.toLocalDate())).collect(Collectors.toList());
        Weather weather;
        forecast.setWeatherList(weatherList);
        switch(tempOption.toLowerCase()){
            case "coolest":
                weather = Collections.min(weatherList,Comparator.comparing(Weather::getTemperature));
                forecast.setCoolestHourOfDay(weather.getLocalDateTime());
                break;
            case "hottest":
                weather = Collections.max(weatherList,Comparator.comparing(Weather::getTemperature));
                forecast.setHottestHourOfDay(weather.getLocalDateTime());
                forecast.setWeatherList(weatherList);
                break;
            default:
                weather = Collections.min(weatherList,Comparator.comparing(Weather::getTemperature));
                forecast.setWeatherList(weatherList);
                forecast.setCoolestHourOfDay(weather.getLocalDateTime());
                break;
        }

        return forecast;
    }
}
