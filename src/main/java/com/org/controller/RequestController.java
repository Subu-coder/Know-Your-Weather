package com.org.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.weather_dao.WeatherDao;
import com.org.weatherdto.Weathering;

@Controller
public class RequestController {
	
	public static HttpServletRequest req;
	
	@RequestMapping("/weatherDetails")
	public ModelAndView getWeatherDetails(HttpServletRequest req) {
		RequestController.req = req;
		
		ModelAndView mav = new ModelAndView("index.jsp");
		
		Weathering weather = Weathering.getWeatherObject();
//		weather.setLoc_city(location);
		
		WeatherDao wd = new WeatherDao();
		wd.fetchWeather(req.getParameter("location"));
		
		
		mav.addObject("wthr",weather);
		return mav;
	}
}
