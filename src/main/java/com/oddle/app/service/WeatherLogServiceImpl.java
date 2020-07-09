package com.oddle.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oddle.app.dao.WeatherLogDAO;
import com.oddle.app.model.WeatherLog;
import com.oddle.app.model.WeatherResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WeatherLogServiceImpl implements WeatherLogService{

    @Autowired
    WeatherLogDAO weatherLogDAO;

    @Override
    public void save(WeatherLog weatherLog) {
        weatherLogDAO.save(weatherLog);
    }

    @Override
    public void delete(long id) {
        weatherLogDAO.deleteWeatherLog(id);
    }

    @Override
    public List<WeatherLog> listAll() {
        return weatherLogDAO.listAllWeatherLog();
    }

    @Override
    public WeatherLog mapToWeatherLog(WeatherResp weatherResp) {
        WeatherLog weatherLog = new WeatherLog();
        weatherLog.setCity(weatherResp.getName());
        weatherLog.setTemperature(weatherResp.getMain().getTemp());
        weatherLog.setWeather(weatherResp.getWeather().get(0).getMain());
        weatherLog.setRawLog(convertToJsonStr(weatherResp));
        return weatherLog;
    }

    private String convertToJsonStr(WeatherResp weatherResp) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(weatherResp);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
