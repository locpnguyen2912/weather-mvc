package com.oddle.app;

import com.oddle.app.controller.WeatherController;
import com.oddle.app.model.WeatherLog;
import com.oddle.app.model.WeatherResp;
import com.oddle.app.service.WeatherLogService;
import com.oddle.app.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class WeatherControllerTest {
    @Mock
    private WeatherLogService weatherLogService;

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
    }

    @Test
    public void validateListAllWeather_Test() throws Exception {
        List<WeatherLog> weatherLogs = new ArrayList<>();
        weatherLogs.add(new WeatherLog());
        weatherLogs.add(new WeatherLog());
        when(weatherLogService.listAll()).thenReturn((List) weatherLogs);

        mockMvc.perform(get("/weather/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("weatherList"))
                .andExpect(model().attribute("weatherList", hasSize(2)));
    }

    @Test
    public void validateSearchWeather_Test() throws Exception {
        String city = "Singapore";
        when(weatherService.getByCity(city)).thenReturn(new WeatherResp());
        when(weatherLogService.mapToWeatherLog(Mockito.any(WeatherResp.class))).thenReturn(new WeatherLog());
        mockMvc.perform(get("/weather/search?searchName=" + city))
                .andExpect(status().isOk())
                .andExpect(view().name("weatherList"))
                .andExpect(model().attribute("weatherList", instanceOf(List.class)));
    }

    @Test
    public void validateDeleteWeather_Test() throws Exception {
        long id = 1;
        mockMvc.perform(get("/weather/delete?id=" + id))
                .andExpect(status().isFound());
    }



}
