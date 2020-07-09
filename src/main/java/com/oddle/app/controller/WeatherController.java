package com.oddle.app.controller;

import com.oddle.app.model.WeatherLog;
import com.oddle.app.model.WeatherResp;
import com.oddle.app.service.WeatherLogService;
import com.oddle.app.service.WeatherService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	private static final Logger logger = Logger.getLogger(WeatherController.class);

	@Autowired
	WeatherService weatherService;

	@Autowired
	WeatherLogService weatherLogService;

	@RequestMapping("list")
	public ModelAndView list(){
		List<WeatherLog> weatherList = weatherLogService.listAll();
		return new ModelAndView("weatherList", "weatherList", weatherList);
	}

	@RequestMapping("search")
	public ModelAndView searchWeather(@RequestParam("searchName") String city) {
		logger.info("Searching weather By City. City: " + city);
		WeatherResp weatherResp = weatherService.getByCity(city);
		WeatherLog weatherLog = weatherLogService.mapToWeatherLog(weatherResp);
		weatherLogService.save(weatherLog);
		return new ModelAndView("weatherList", "weatherList", Collections.singletonList(weatherLog));
	}

	@RequestMapping("delete")
	public ModelAndView deleteEmployee(@RequestParam long id) {
		logger.info("Deleting the weather. Id : "+id);
		weatherLogService.delete(id);
		return new ModelAndView("redirect:list");
	}

}
