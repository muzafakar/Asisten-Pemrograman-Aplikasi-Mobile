package com.muzadev.asistenpemrogramanaplikasimobile.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofiteClient {
    private static final String BASE_URL =
            "https://openweathermap.org/data/2.5/";

    public static Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
