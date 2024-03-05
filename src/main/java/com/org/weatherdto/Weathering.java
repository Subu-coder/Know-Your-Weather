package com.org.weatherdto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.org.weather_dao.WeatherDao;


public class Weathering {

	static {
		WeatherDao wd = new WeatherDao();
		wd.fetchWeather("Delhi");
	}
	
	private static Weathering weather;

	private int id;
	private String icon_id;

	private String loc_city;
	private String loc_country;

	private int temp;
	private int feels_like;
	private int humidity;
	private int pressure;

	private int windSpeed;

	private double visibility;
	private String atmosphere;

//	private final String[] weekDays = {"Sunday", "Monday", "Tueday", "Wednesday", "Thursday", "Friday", "Saturday"};
//	private final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};

	Date d = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat("E,MMMM dd");
	String date = dateformat.format(d);

	SimpleDateFormat timeobj = new SimpleDateFormat("hh:mm a");
	private String time = timeobj.format(d);

	// private Contructor
	private Weathering() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoc_city() {
		return loc_city;
	}

	public void setLoc_city(String loc_city) {
		this.loc_city = loc_city;
	}

	public String getLoc_country() {
		return loc_country;
	}

	public void setLoc_country(String loc_country) {
		this.loc_country = loc_country;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(int feels_like) {
		this.feels_like = feels_like;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public String getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}

	public String getIcon_id() {
		return icon_id;
	}

	public void setIcon_id(String icon_id) {
		this.icon_id = icon_id;
	}

	public int getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}

	public static Weathering getWeatherObject() {
		if (weather == null) {
			weather = new Weathering();
			return weather;
		}
		return weather;
	}

	public String getTime() {
		return time;
	}

	public String getDate() {
		return date;
	}

}
