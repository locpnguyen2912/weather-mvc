package com.oddle.app.service;

import com.oddle.app.model.WeatherResp;
import lombok.SneakyThrows;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    @Override
    public WeatherResp getByCity(String city) {
        ResponseEntity<WeatherResp> response = restTemplate.getForEntity(
                buildURI(city), WeatherResp.class);
        return response.getBody();
    }

    @SneakyThrows
    private String buildURI(String city) {
        URIBuilder builder = new URIBuilder(environment.getRequiredProperty("openweather.api"));
        builder.addParameter("q", city);
        builder.addParameter("appid", environment.getRequiredProperty("openweather.appid"));
        URL url = builder.build().toURL();
        return url.toString();
    }


}
