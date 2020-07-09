package com.oddle.app.service;

import com.oddle.app.model.WeatherResp;

public interface WeatherService {
    WeatherResp getByCity(String city);
}
