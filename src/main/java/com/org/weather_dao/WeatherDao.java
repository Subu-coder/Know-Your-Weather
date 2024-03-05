package com.org.weather_dao;

import java.io.IOException;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.org.controller.RequestController;
import com.org.properties.WeatherProperties;
import com.org.weatherdto.Weathering;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherDao {

	Weathering weather;

	public Weathering fetchWeather(String location) {

		// TO make Http requests
		OkHttpClient client = new OkHttpClient();

		// I have used OpenWeatherMap's API key
		// Your API Key
		String api_key = WeatherProperties.YOUR_API_KEY;

		String city = location;

		// url from api request to get weather details
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + api_key
				+ "&units=metric";

		// Create a new request using the constructed URL
		Request req = new Request.Builder().url(url).build();

		try {

			// To fetch the response from sent request
			// Response will be fetched in form of JSON file
			Response resp = client.newCall(req).execute();

			// Extracting the response body as string
			String respBody = resp.body().string();

			// Parsing the string to JSON format as object
			JSONObject json = new JSONObject(respBody);

			// Fetch main object from JSON
			JSONObject jsonMain = json.getJSONObject("main");
			// Fetching weather array from JSON
			JSONArray jsonWeather = json.getJSONArray("weather");

			weather = Weathering.getWeatherObject();
			// Fetching objects stored in JSONArrays then from that object fetching values
			// using key
			weather.setId(jsonWeather.getJSONObject(0).getInt("id"));
			weather.setIcon_id(jsonWeather.getJSONObject(0).getString("icon"));
			weather.setAtmosphere(jsonWeather.getJSONObject(0).getString("main"));

			weather.setTemp(jsonMain.getInt("temp"));
			weather.setHumidity((int) Math.round(jsonMain.getDouble("humidity")));
			weather.setFeels_like((int) Math.round(jsonMain.getDouble("feels_like")));
			weather.setPressure(jsonMain.getInt("pressure"));

			weather.setWindSpeed((int) Math.round(json.getJSONObject("wind").getDouble("speed") * 3.6));
			weather.setVisibility((json.getInt("visibility")) / 1000);

			weather.setLoc_city(json.getString("name"));
			weather.setLoc_country(
					new Locale("ENGLISH", json.getJSONObject("sys").getString("country")).getDisplayCountry());

		} catch (IOException e) {

			e.printStackTrace();
		}

		catch (JSONException jsone) {
			RequestController.req.setAttribute("isLocValid", "false");

			jsone.printStackTrace();
		}

		return weather;
	}

}
