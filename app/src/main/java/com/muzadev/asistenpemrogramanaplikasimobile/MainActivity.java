package com.muzadev.asistenpemrogramanaplikasimobile;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.muzadev.asistenpemrogramanaplikasimobile.model.WeatherResponse;
import com.muzadev.asistenpemrogramanaplikasimobile.network.RetrofiteClient;
import com.muzadev.asistenpemrogramanaplikasimobile.network.WeatherApi;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    // Deklarasi objek
    private ImageView imgWheaterIcon;
    private TextView tvCondition, tvTemperature, tvCityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi
        bindView();
        getWeatherData();
//        getWeatherDataRetrofit();
    }

    private void getWeatherData() {
        String url = "https://openweathermap.org/data/2.5/weather?appid=b6907d289e10d714a6e88b30761fae22&q=Yogyakarta";

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseData = response.body().string();
                try {
                    // manually parse the response array
                    JSONObject jsonData = new JSONObject(responseData);
                    final String cityName = jsonData.getString("name");
                    JSONArray weatherArray = jsonData.getJSONArray("weather");

                    JSONObject weatherObject = new JSONObject(weatherArray.getJSONObject(0).toString());
                    final String weatherCondition = weatherObject.getString("description");
                    final String icon = weatherObject.getString("icon");

                    JSONObject mainObject = jsonData.getJSONObject("main");
                    final double temperature = mainObject.getDouble("temp");

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showData(cityName, weatherCondition, icon, temperature);
                        }
                    });
                } catch (Exception ex) {
                    Log.e("Response", ex.getMessage());
                }
            }
        });
    }

    private void getWeatherDataRetrofit() {
        Retrofit retrofit = RetrofiteClient.create();
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        String cityName = "Yogyakarta";
        String apiToken = "b6907d289e10d714a6e88b30761fae22";

        weatherApi.getWheater(cityName, apiToken).enqueue(new retrofit2.Callback<WeatherResponse>() {
            @Override
            public void onResponse(retrofit2.Call<WeatherResponse> call, retrofit2.Response<WeatherResponse> response) {
                String cityName = response.body().getName();
                String condition = response.body().getWeather().get(0).getDescription();
                String icon = response.body().getWeather().get(0).getIcon();
                double temperature = response.body().getMain().getTemp();

                showData(cityName, condition, icon, temperature);
            }

            @Override
            public void onFailure(retrofit2.Call<WeatherResponse> call, Throwable t) {

            }
        });
    }

    private void showData(String cityName, String weatherCondition, String icon, double temperature) {
        tvCityName.setText(cityName);
        tvCondition.setText(weatherCondition);
        tvTemperature.setText(temperature + " C");

        String iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
        Glide.with(this).load(iconUrl).into(imgWheaterIcon);
    }

    private void bindView() {
        imgWheaterIcon = findViewById(R.id.imgWheaterIcon);
        tvCondition = findViewById(R.id.tvCondition);
        tvTemperature = findViewById(R.id.tvTemperature);
        tvCityName = findViewById(R.id.tvCityName);
    }

}
