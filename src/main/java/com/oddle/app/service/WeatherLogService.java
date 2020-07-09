package com.oddle.app.service;

import com.oddle.app.model.WeatherLog;
import com.oddle.app.model.WeatherResp;

import java.util.List;

public interface WeatherLogService {
    public void save(WeatherLog weatherLog);

    public void delete(long id);

    public List<WeatherLog> listAll();

    public WeatherLog mapToWeatherLog(WeatherResp weatherResp);

}
