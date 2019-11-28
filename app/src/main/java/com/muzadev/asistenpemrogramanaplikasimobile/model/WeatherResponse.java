package com.muzadev.asistenpemrogramanaplikasimobile.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class WeatherResponse{

	@SerializedName("dt")
	private int dt;

	@SerializedName("coord")
	private Coord coord;

	@SerializedName("timezone")
	private int timezone;

	@SerializedName("weather")
	private List<WeatherItem> weather;

	@SerializedName("name")
	private String name;

	@SerializedName("cod")
	private int cod;

	@SerializedName("main")
	private Main main;

	@SerializedName("clouds")
	private Clouds clouds;

	@SerializedName("id")
	private int id;

	@SerializedName("sys")
	private Sys sys;

	@SerializedName("base")
	private String base;

	@SerializedName("wind")
	private Wind wind;

	public int getDt(){
		return dt;
	}

	public Coord getCoord(){
		return coord;
	}

	public int getTimezone(){
		return timezone;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public String getName(){
		return name;
	}

	public int getCod(){
		return cod;
	}

	public Main getMain(){
		return main;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public int getId(){
		return id;
	}

	public Sys getSys(){
		return sys;
	}

	public String getBase(){
		return base;
	}

	public Wind getWind(){
		return wind;
	}
}