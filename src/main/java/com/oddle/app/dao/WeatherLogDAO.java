package com.oddle.app.dao;

import com.oddle.app.model.WeatherLog;

import java.util.List;

public interface WeatherLogDAO {
    public void save(WeatherLog weatherLog);
    public void deleteWeatherLog(Long id);
    public List<WeatherLog> listAllWeatherLog();
}
