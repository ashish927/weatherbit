package com.example.weatherForcasting.helper;

import com.example.weatherForcasting.model.Duration;
import com.example.weatherForcasting.model.Forecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class WeatherBitHelper {

    @Value("${weatherbit.api.key}")
    private String apiKey;

    @Value("${default.lang}")
    private String lang;

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherBitHelper.class);


    @Autowired
    private RestTemplate restTemplate;

    public Forecast getHourlyForecast(String countryCode, String zipCode, Duration duration) {
        return restTemplate.getForObject(getUrl(countryCode, zipCode, duration), Forecast.class);
    }

    private String getUrl (String countryCode, String zipCode, Duration duration){
        return "https://api.weatherbit.io/v2.0/forecast/hourly?postal_code="+zipCode+"&country="+countryCode+"&units=S"+"&lang="+lang+"&duration="+duration.getValue()+"&key="+apiKey;
    }

}
