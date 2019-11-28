package com.muzadev.asistenpemrogramanaplikasimobile.network;

import com.muzadev.asistenpemrogramanaplikasimobile.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("weather")
    Call<WeatherResponse> getWheater(
            @Query("q") String cityName,
            @Query("appid") String apiToken
    );
}
