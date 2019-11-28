package com.muzadev.asistenpemrogramanaplikasimobile.network;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WheaterApi {
    @GET("weather")
    Call<JSONObject> getWheater(
            @Query("q") String cityName,
            @Query("appid") String apiToken
    );
}
